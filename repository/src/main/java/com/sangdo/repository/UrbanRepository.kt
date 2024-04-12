package com.sangdo.repository

import com.sangdo.network.UrbanDictionaryClient
import com.sangdo.network.data.UrbanDictionaryData
import com.sangdo.repository.model.UrbanModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Inject

class SangdoUrbanRepository @Inject constructor(
    private val client: UrbanDictionaryClient,
) : UrbanRepository {

    override fun getDefinition(word: String) = client
        .requestDefine(word)
        .mapNotNull { data -> data.toListOfUrbanModel() }

    private fun UrbanDictionaryData.toListOfUrbanModel() = list
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