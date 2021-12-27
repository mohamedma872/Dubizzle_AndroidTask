package com.dubizzle.local.mapper

import com.dubizzle.data.model.ListingsData
import com.dubizzle.local.model.ListingsLocal
import javax.inject.Inject


class ListingsLocalMapper @Inject constructor() : Mapper<ListingsData, ListingsLocal> {

    override fun from(e: ListingsLocal): ListingsData {
        return ListingsData(
            uid = e.uid,
            price = e.price,
            name = e.name,
            createdAt = e.createdAt,
            imageIds = e.imageIds,
            imageUrls = e.imageUrls,
            imageUrlsThumbnails = e.imageUrlsThumbnails
        )
    }

    override fun to(t: ListingsData): ListingsLocal {
        return ListingsLocal(
            uid = t.uid,
            price = t.price,
            name = t.name,
            createdAt = t.createdAt,
            imageIds = t.imageIds,
            imageUrls = t.imageUrls,
            imageUrlsThumbnails = t.imageUrlsThumbnails
        )
    }
}