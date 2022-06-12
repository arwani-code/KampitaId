package com.picodiploma.kampitaid.di

import android.content.Context
import com.picodiploma.kampitaid.data.QuakeRepository
import com.picodiploma.kampitaid.data.local.room.QuakeDatabase
import com.picodiploma.kampitaid.data.remote.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): QuakeRepository{
        val database = QuakeDatabase.getInstance(context)
        val apiService = ApiConfig.getApiService()
        val quakeDao = database.quakeDao()
        return QuakeRepository.getInstance(quakeDao, apiService)
    }
}