package com.dubizzle.local.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("first_air_date")
    val firstAirDate: String?, // 2018-08-17
    @SerializedName("id")
    val id: Int, // 299536
    @SerializedName("name")
    val name: String?, // Disenchantment
    @SerializedName("original_name")
    val originalName: String?, // Disenchantment
    @SerializedName("original_title")
    val originalTitle: String?, // Avengers: Infinity War
    @SerializedName("overview")
    val overview: String, // As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.
    @SerializedName("poster_path")
    val posterPath: String, // /7WsyChQLEftFiDOVTGkv3hFpyyt.jpg
)