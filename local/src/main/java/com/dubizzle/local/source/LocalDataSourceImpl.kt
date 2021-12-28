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

    companion object {
        private const val DEFAULT_LIMIT = 40
    }

    override fun getListings(limit: Int?): Observable<List<ListingsData>> {
        return listingsDAO.getListings(limit ?: DEFAULT_LIMIT)
            .map { localItems ->
                localItems.map {
                    println("Local Invoked")
                    listingsMapper.from(it)
                }
            }
    }

    override fun getListingsByID(uid: String): Observable<ListingsData> {
        return listingsDAO.listingsById(uid)
            .map {
                println("Local get transactions Invoked")
                listingsMapper.from(it)
            }
    }

    override fun saveListings(listings: List<ListingsData>) {
        listingsDAO.addListings(
            listings.map {
                listingsMapper.to(it)
            }
        )
    }


}
