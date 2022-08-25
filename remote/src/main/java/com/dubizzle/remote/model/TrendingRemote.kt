package com.dubizzle.remote.model


import com.google.gson.annotations.SerializedName

data class TrendingRemote(
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val results: List<Movie>
)