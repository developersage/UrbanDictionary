package com.sangdo.network

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Inject

class UrbanDictionaryClient @Inject constructor(
    private val service: UrbanDictionaryService
) {
    fun requestDefine(word: String) = flow { emit(service.define(word)) }
        .mapNotNull { response ->
            if (response.isSuccessful) response.body()
            else throw Exception(response.errorBody().toString())
        }

}

