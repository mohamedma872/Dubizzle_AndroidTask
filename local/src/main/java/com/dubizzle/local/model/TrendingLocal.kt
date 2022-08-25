package com.dubizzle.local.model


import com.google.gson.annotations.SerializedName

data class TrendingLocal(
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val results: List<Movie>
)