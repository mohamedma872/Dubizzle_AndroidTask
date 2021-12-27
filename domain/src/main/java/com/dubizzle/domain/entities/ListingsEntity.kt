package com.dubizzle.domain.entities

data class ListResponse(
    val pagination: Pagination? = null,
    var results: List<ListingsEntity?>? = null
)

data class Pagination(
    val key: Any? = null
)

data class ListingsEntity(
    val uid: String,

    val price: String? = null,

    val name: String? = null,

    val createdAt: String? = null,

    val imageIds: List<String?>? = null,

    val imageUrls: List<String?>? = null,

    val imageUrlsThumbnails: List<String?>? = null
)