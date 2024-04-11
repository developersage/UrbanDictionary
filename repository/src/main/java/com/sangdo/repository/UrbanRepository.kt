package com.sangdo.repository

import com.sangdo.network.UrbanDictionaryService
import com.sangdo.network.data.UrbanDictionaryData
import com.sangdo.repository.model.UrbanModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SangdoUrbanRepository @Inject constructor(
    private val urbanDictionaryService: UrbanDictionaryService,
) : UrbanRepository {

    override fun getDefinition(word: String) = flow {
        urbanDictionaryService.define(word)
            .run {
                if (isSuccessful) emit(body().toListOfUrbanModel())
                else throw Exception("Error")
            }
    }

    private fun UrbanDictionaryData?.toListOfUrbanModel() = this
        ?.list
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