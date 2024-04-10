package com.sangdo.urban.repository

import com.sangdo.network.module.UrbanDictionaryService
import com.sangdo.network.module.UrbanModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SangdoUrbanRepository @Inject constructor(
    private val urbanDictionaryService: UrbanDictionaryService,
) : UrbanRepository {
    override fun getDefinition(word: String) = urbanDictionaryService.define(word)
}

interface UrbanRepository {
    fun getDefinition(word: String): Flow<UrbanModel>
}