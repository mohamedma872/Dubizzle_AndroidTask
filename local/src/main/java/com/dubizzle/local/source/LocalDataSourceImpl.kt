package com.dubizzle.local.source

import com.dubizzle.data.model.ListingsData
import com.dubizzle.data.repository.LocalDataSource
import com.dubizzle.local.database.ListingsDAO
import com.dubizzle.local.mapper.ListingsDataLocalMapper
import io.reactivex.Observable
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val listingsMapper: ListingsDataLocalMapper,
    private val listingsDAO: ListingsDAO,
) : LocalDataSource {

    override fun getListings(limit: Int): List<ListingsData> {
        return listingsDAO.getListings(limit)
            .map {
                listingsMapper.from(it)
                }
            }

    override fun getListingsByID(uid: String): ListingsData  {
        return listingsMapper.from(listingsDAO.listingsById(uid))
    }

    override suspend fun saveListings(listings: List<ListingsData>) {
        listingsDAO.addListings(
            listings.map {
                listingsMapper.to(it)
            }
        )
    }
}
