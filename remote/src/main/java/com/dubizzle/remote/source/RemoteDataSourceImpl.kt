package com.dubizzle.remote.source

import com.dubizzle.data.model.ListingsData
import com.dubizzle.data.repository.RemoteDataSource
import com.dubizzle.remote.api.ListingsService
import com.dubizzle.remote.mapper.Mapper
import com.dubizzle.remote.model.ListingsNetwork
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val listingsMapper: Mapper<ListingsData, ListingsNetwork>,
    private val listingsService: ListingsService
) : RemoteDataSource {

    override suspend fun getListings(limit: Int): List<ListingsData> {
        return listingsService.getListings().body()!!.results
            ?.map{ listing: ListingsNetwork ->
                listingsMapper.from(listing)
            } ?: emptyList()
    }
        }

