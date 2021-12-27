package com.dubizzle.presentation.model

data class Listings (
    val uid: String? = null,

    val price: String? = null,

    val name: String? = null,

    val createdAt: String? = null,

    val imageIds: List<String?>? = null,

    val imageUrls: List<String?>? = null,

    val imageUrlsThumbnails: List<String?>? = null
)