package com.picodiploma.kampitaid.data.remote.retrofit

import com.picodiploma.kampitaid.data.remote.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/")
    suspend fun getLisQuake(): SeismicDataResponse

}