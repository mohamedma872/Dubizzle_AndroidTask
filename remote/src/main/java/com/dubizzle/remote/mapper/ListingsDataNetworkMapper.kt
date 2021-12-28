package com.dubizzle.remote.mapper

import com.dubizzle.data.model.ListingsData
import com.dubizzle.remote.mapper.Mapper
import com.dubizzle.remote.model.ListingsNetwork

import javax.inject.Inject

class ListingsDataNetworkMapper @Inject constructor():
    Mapper<ListingsData, ListingsNetwork> {
    override fun from(e: ListingsNetwork): ListingsData {
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

    override fun to(t: ListingsData): ListingsNetwork {
        return ListingsNetwork(
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