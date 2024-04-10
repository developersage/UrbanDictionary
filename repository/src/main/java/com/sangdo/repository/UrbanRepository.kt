package com.sangdo.repository

import com.sangdo.network.UrbanDictionaryService
import com.sangdo.network.data.UrbanDictionaryData
import com.sangdo.repository.model.UrbanModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class SangdoUrbanRepository @Inject constructor(
    private val urbanDictionaryService: UrbanDictionaryService,
) : UrbanRepository {

    override fun getDefinition(word: String) = urbanDictionaryService.define(word)
        .mapNotNull { response -> response.toListOfUrbanModel() }

    private fun UrbanDictionaryData.toListOfUrbanModel(): List<UrbanModel> = list
        ?.map { detail ->
            detail.run {
                UrbanModel(
                    word.orEmpty(),
                    author.orEmpty(),
                    definition.orEmpty(),
                    example.orEmpty(),
                    thumbsUp?.toString().orEmpty(),
                    thumbsDown?.toString().orEmpty(),
                    permalink.orEmpty()
                )
            }
        }
        ?: emptyList()
}

interface UrbanRepository {
    fun getDefinition(word: String): Flow<List<UrbanModel>>
}