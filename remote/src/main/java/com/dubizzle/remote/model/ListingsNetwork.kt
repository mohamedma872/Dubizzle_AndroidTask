package com.dubizzle.remote.model

import com.google.gson.annotations.SerializedName


data class ListingsNetwork(
    @SerializedName("uid") val uid: String,

    @SerializedName("price") val price: String? = null,

    @SerializedName("name") val name: String? = null,

    @SerializedName("created_at") val createdAt: String? = null,

    @SerializedName("image_ids") val imageIds: List<String?>? = null,

    @SerializedName("image_urls") val imageUrls: List<String?>? = null,

    @SerializedName("image_urls_thumbnails") val imageUrlsThumbnails: List<String?>? = null
)