package com.sangdo.network

import com.sangdo.network.data.UrbanDictionaryData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UrbanDictionaryService {

    @GET("define")
    suspend fun define(
        @Query("term") word: String
    ): Response<UrbanDictionaryData>
}