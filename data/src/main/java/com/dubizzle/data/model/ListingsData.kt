package com.dubizzle.data.model

data class ListingsData (
    val uid: String,

    val price: String? = null,

    val name: String? = null,

    val createdAt: String? = null,

    val imageIds: List<String?>? = null,

    val imageUrls: List<String?>? = null,

    val imageUrlsThumbnails: List<String?>? = null
)