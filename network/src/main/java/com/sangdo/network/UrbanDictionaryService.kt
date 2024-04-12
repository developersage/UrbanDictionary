package com.sangdo.network

import com.sangdo.network.data.UrbanDictionaryData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface UrbanDictionaryService {

    @GET("/define")
    suspend fun define(
        @Query("term") word: String,
        @Header("X-RapidAPI-Key") apiKey: String = BuildConfig.URBAN_API_Key,
        @Header("X-RapidAPI-Host") host: String = BuildConfig.URBAN_API_Host
    ): Response<UrbanDictionaryData>

}