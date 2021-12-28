package com.dubizzle.remote.model

import com.google.gson.annotations.SerializedName

class ResponseWrapper(
    @SerializedName("pagination") val pagination: Pagination? = null,
    @SerializedName("results") var results: List<ListingsNetwork>? = null
)

data class Pagination(
    val key: Any? = null
)