package com.sangdo.network.module

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface UrbanDictionaryService {

    @GET("define")
    fun define(@Path("term") word: String): Flow<UrbanModel>
}