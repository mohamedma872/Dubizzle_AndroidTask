package com.dubizzle.presentation.mapper

import com.dubizzle.domain.entities.ListingsEntity
import com.dubizzle.presentation.model.Listings
import javax.inject.Inject


class ListingsEntityMapper @Inject constructor() : Mapper<ListingsEntity, Listings> {

    override fun from(e: Listings): ListingsEntity {
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

    override fun to(t: ListingsEntity): Listings {
        return Listings(
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