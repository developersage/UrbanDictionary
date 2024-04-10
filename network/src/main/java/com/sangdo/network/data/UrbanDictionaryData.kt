package com.sangdo.network.data

import com.squareup.moshi.Json

data class UrbanDictionaryData(
    val list: List<UrbanDictionaryDetails>?
)

data class UrbanDictionaryDetails(
    val definition: String?,
    val permalink: String?,

    @Json(name = "thumbs_up")
    val thumbsUp: Int?,
    val author: String?,
    val word: String?,

    @Json(name = "written_on")
    val writtenOn: String?,
    val example: String?,

    @Json(name = "thumbs_down")
    val thumbsDown: Int?,
)