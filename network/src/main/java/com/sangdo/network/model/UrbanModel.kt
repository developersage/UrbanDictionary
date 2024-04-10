package com.sangdo.network.model

import com.squareup.moshi.Json

data class UrbanModel(
    val list: List<UrbanDetails>
)

data class UrbanDetails(
    val definition: String,
    val permalink: String,

    @Json(name = "thumbs_up")
    val thumbsUp: Int,
    val author: String,
    val word: String,

    @Json(name = "written_on")
    val writtenOn: String,
    val example: String,

    @Json(name = "thumbs_down")
    val thumbsDown: Int,
)