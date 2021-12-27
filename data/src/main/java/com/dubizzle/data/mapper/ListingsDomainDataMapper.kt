package com.dubizzle.data.mapper

import com.dubizzle.data.model.ListingsData
import com.dubizzle.domain.entities.ListingsEntity
import javax.inject.Inject


class ListingsDomainDataMapper @Inject constructor() : Mapper<ListingsEntity, ListingsData> {

    override fun from(e: ListingsData): ListingsEntity {
        return ListingsEntity(
            uid = e.uid,
            price = e.price,
            name = e.name,
            createdAt = e.createdAt,
            imageIds = e.imageIds,
            imageUrls = e.imageUrls,
            imageUrlsThumbnails = e.imageUrlsThumbnails
        )
    }

    override fun to(t: ListingsEntity): ListingsData {
        return ListingsData(
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