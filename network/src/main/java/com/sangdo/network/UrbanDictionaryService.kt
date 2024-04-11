package com.sangdo.network

import com.sangdo.network.data.UrbanDictionaryData
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface UrbanDictionaryService {

    @GET("define")
    fun define(
        @Query("term") word: String
    ): Flow<UrbanDictionaryData>
}