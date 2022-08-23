package com.dubizzle.data.repository

import com.dubizzle.data.model.ListingsData
import io.reactivex.Observable


interface LocalDataSource {
    fun getListings(limit: Int): List<ListingsData>
    fun getListingsByID(uid: String): ListingsData
    suspend fun saveListings(listings: List<ListingsData>)

}