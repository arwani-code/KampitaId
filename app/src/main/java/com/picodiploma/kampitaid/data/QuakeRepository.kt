package com.picodiploma.kampitaid.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.picodiploma.kampitaid.data.local.entity.QuakeEntity
import com.picodiploma.kampitaid.data.local.room.QuakeDao
import com.picodiploma.kampitaid.data.remote.response.SeismicResponse
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
                    station = quakeData.jsonMember1?.station,
                    station_location = quakeData.jsonMember1?.stationLocation,
                    elevation = quakeData.jsonMember1?.elevation,
                    latitude = quakeData.jsonMember1?.latitude,
                    longitude = quakeData.jsonMember1?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember2?.station,
                    station_location = quakeData.jsonMember2?.stationLocation,
                    elevation = quakeData.jsonMember2?.elevation,
                    latitude = quakeData.jsonMember2?.latitude,
                    longitude = quakeData.jsonMember2?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember3?.station,
                    station_location = quakeData.jsonMember3?.stationLocation,
                    elevation = quakeData.jsonMember3?.elevation,
                    latitude = quakeData.jsonMember3?.latitude,
                    longitude = quakeData.jsonMember3?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember4?.station,
                    station_location = quakeData.jsonMember4?.stationLocation,
                    elevation = quakeData.jsonMember4?.elevation,
                    latitude = quakeData.jsonMember4?.latitude,
                    longitude = quakeData.jsonMember4?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember5?.station,
                    station_location = quakeData.jsonMember5?.stationLocation,
                    elevation = quakeData.jsonMember5?.elevation,
                    latitude = quakeData.jsonMember5?.latitude,
                    longitude = quakeData.jsonMember5?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember6?.station,
                    station_location = quakeData.jsonMember6?.stationLocation,
                    elevation = quakeData.jsonMember6?.elevation,
                    latitude = quakeData.jsonMember6?.latitude,
                    longitude = quakeData.jsonMember6?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember7?.station,
                    station_location = quakeData.jsonMember7?.stationLocation,
                    elevation = quakeData.jsonMember7?.elevation,
                    latitude = quakeData.jsonMember7?.latitude,
                    longitude = quakeData.jsonMember7?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember8?.station,
                    station_location = quakeData.jsonMember8?.stationLocation,
                    elevation = quakeData.jsonMember8?.elevation,
                    latitude = quakeData.jsonMember8?.latitude,
                    longitude = quakeData.jsonMember8?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember9?.station,
                    station_location = quakeData.jsonMember9?.stationLocation,
                    elevation = quakeData.jsonMember9?.elevation,
                    latitude = quakeData.jsonMember9?.latitude,
                    longitude = quakeData.jsonMember9?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember10?.station,
                    station_location = quakeData.jsonMember10?.stationLocation,
                    elevation = quakeData.jsonMember10?.elevation,
                    latitude = quakeData.jsonMember10?.latitude,
                    longitude = quakeData.jsonMember10?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember11?.station,
                    station_location = quakeData.jsonMember11?.stationLocation,
                    elevation = quakeData.jsonMember11?.elevation,
                    latitude = quakeData.jsonMember11?.latitude,
                    longitude = quakeData.jsonMember11?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember12?.station,
                    station_location = quakeData.jsonMember12?.stationLocation,
                    elevation = quakeData.jsonMember12?.elevation,
                    latitude = quakeData.jsonMember12?.latitude,
                    longitude = quakeData.jsonMember12?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember13?.station,
                    station_location = quakeData.jsonMember13?.stationLocation,
                    elevation = quakeData.jsonMember13?.elevation,
                    latitude = quakeData.jsonMember13?.latitude,
                    longitude = quakeData.jsonMember13?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember14?.station,
                    station_location = quakeData.jsonMember14?.stationLocation,
                    elevation = quakeData.jsonMember14?.elevation,
                    latitude = quakeData.jsonMember14?.latitude,
                    longitude = quakeData.jsonMember14?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember15?.station,
                    station_location = quakeData.jsonMember15?.stationLocation,
                    elevation = quakeData.jsonMember15?.elevation,
                    latitude = quakeData.jsonMember15?.latitude,
                    longitude = quakeData.jsonMember15?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember16?.station,
                    station_location = quakeData.jsonMember16?.stationLocation,
                    elevation = quakeData.jsonMember16?.elevation,
                    latitude = quakeData.jsonMember16?.latitude,
                    longitude = quakeData.jsonMember16?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember17?.station,
                    station_location = quakeData.jsonMember17?.stationLocation,
                    elevation = quakeData.jsonMember17?.elevation,
                    latitude = quakeData.jsonMember17?.latitude,
                    longitude = quakeData.jsonMember17?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember18?.station,
                    station_location = quakeData.jsonMember18?.stationLocation,
                    elevation = quakeData.jsonMember18?.elevation,
                    latitude = quakeData.jsonMember18?.latitude,
                    longitude = quakeData.jsonMember18?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember19?.station,
                    station_location = quakeData.jsonMember19?.stationLocation,
                    elevation = quakeData.jsonMember19?.elevation,
                    latitude = quakeData.jsonMember19?.latitude,
                    longitude = quakeData.jsonMember19?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember20?.station,
                    station_location = quakeData.jsonMember20?.stationLocation,
                    elevation = quakeData.jsonMember20?.elevation,
                    latitude = quakeData.jsonMember20?.latitude,
                    longitude = quakeData.jsonMember20?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember21?.station,
                    station_location = quakeData.jsonMember21?.stationLocation,
                    elevation = quakeData.jsonMember21?.elevation,
                    latitude = quakeData.jsonMember21?.latitude,
                    longitude = quakeData.jsonMember21?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember22?.station,
                    station_location = quakeData.jsonMember22?.stationLocation,
                    elevation = quakeData.jsonMember22?.elevation,
                    latitude = quakeData.jsonMember22?.latitude,
                    longitude = quakeData.jsonMember22?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember23?.station,
                    station_location = quakeData.jsonMember23?.stationLocation,
                    elevation = quakeData.jsonMember23?.elevation,
                    latitude = quakeData.jsonMember23?.latitude,
                    longitude = quakeData.jsonMember23?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember24?.station,
                    station_location = quakeData.jsonMember24?.stationLocation,
                    elevation = quakeData.jsonMember24?.elevation,
                    latitude = quakeData.jsonMember24?.latitude,
                    longitude = quakeData.jsonMember24?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember25?.station,
                    station_location = quakeData.jsonMember25?.stationLocation,
                    elevation = quakeData.jsonMember25?.elevation,
                    latitude = quakeData.jsonMember25?.latitude,
                    longitude = quakeData.jsonMember25?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember26?.station,
                    station_location = quakeData.jsonMember26?.stationLocation,
                    elevation = quakeData.jsonMember26?.elevation,
                    latitude = quakeData.jsonMember26?.latitude,
                    longitude = quakeData.jsonMember26?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember27?.station,
                    station_location = quakeData.jsonMember27?.stationLocation,
                    elevation = quakeData.jsonMember27?.elevation,
                    latitude = quakeData.jsonMember27?.latitude,
                    longitude = quakeData.jsonMember27?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember28?.station,
                    station_location = quakeData.jsonMember28?.stationLocation,
                    elevation = quakeData.jsonMember28?.elevation,
                    latitude = quakeData.jsonMember28?.latitude,
                    longitude = quakeData.jsonMember28?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember29?.station,
                    station_location = quakeData.jsonMember29?.stationLocation,
                    elevation = quakeData.jsonMember29?.elevation,
                    latitude = quakeData.jsonMember29?.latitude,
                    longitude = quakeData.jsonMember29?.longitude
                )
            )
            quakeDao.insertQuake(
                QuakeEntity(
                    station = quakeData.jsonMember30?.station,
                    station_location = quakeData.jsonMember30?.stationLocation,
                    elevation = quakeData.jsonMember30?.elevation,
                    latitude = quakeData.jsonMember30?.latitude,
                    longitude = quakeData.jsonMember30?.longitude
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