package com.dubizzle.remote.model

import com.google.gson.annotations.SerializedName


data class ListingsNetwork(
    @SerializedName("uid") val uid: String,

    @SerializedName("price") val price: String? = null,

    @SerializedName("name") val name: String? = null,

    @SerializedName("createdAt") val createdAt: String? = null,

    @SerializedName("imageIds") val imageIds: List<String?>? = null,

    @SerializedName("imageUrls") val imageUrls: List<String?>? = null,

    @SerializedName("imageUrlsThumbnails") val imageUrlsThumbnails: List<String?>? = null
)