package com.picodiploma.kampitaid.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.picodiploma.kampitaid.data.local.entity.QuakeEntity
import com.picodiploma.kampitaid.data.local.room.QuakeDao
import com.picodiploma.kampitaid.data.remote.retrofit.ApiService
import java.lang.Exception

class QuakeRepository private constructor(
    private val quakeDao: QuakeDao,
    private val apiService: ApiService
) {
    fun getListQuake(): LiveData<Result<List<QuakeEntity>>> = liveData {
        emit(Result.Loading)
        try {
            val quakeData = apiService.getLisQuake()
            quakeDao.deleteAllQuake()
            quakeDao.insertQuake(
                QuakeEntity(
                    latitude = quakeData.jsonMember20?.latitude,
                    longitude = quakeData.jsonMember20?.longitude,
                    radius = quakeData.jsonMember20?.radius,
                    publishedAt = quakeData.jsonMember20?.pWaveDate,
                )
            )

        } catch (ex: Exception) {
            emit(Result.Error(ex.message.toString()))
        }
        val localData: LiveData<Result<List<QuakeEntity>>> =
            quakeDao.getListQuake().map { Result.Success(it) }
        emitSource(localData)
    }

    fun getSearchQuake(title: String?): LiveData<Result<List<QuakeEntity>>> = liveData {
        val localData: LiveData<Result<List<QuakeEntity>>> =
            quakeDao.getSearchQuake(title).map { Result.Success(it) }
        emitSource(localData)
    }

    companion object {
        @Volatile
        private var instance: QuakeRepository? = null
        fun getInstance(
            quakeDao: QuakeDao,
            apiService: ApiService
        ): QuakeRepository =
            instance ?: synchronized(this) {
                instance ?: QuakeRepository(quakeDao, apiService)
            }.also { instance = it }
    }
}