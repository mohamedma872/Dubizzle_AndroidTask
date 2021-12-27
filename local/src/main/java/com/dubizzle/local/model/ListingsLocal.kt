package com.dubizzle.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "listings")
data class ListingsLocal (
    @PrimaryKey @ColumnInfo(name = "uid") val uid: String,
    @ColumnInfo(name = "price") val price: String? = null,
    @ColumnInfo(name = "name") val name: String? = null,
    @ColumnInfo(name = "createdAt") val createdAt: String? = null,
    @ColumnInfo(name = "imageIds") val imageIds: List<String?>? = null,
    @ColumnInfo(name = "imageUrls") val imageUrls: List<String?>? = null,
    @ColumnInfo(name = "imageUrlsThumbnails") val imageUrlsThumbnails: List<String?>? = null
)
