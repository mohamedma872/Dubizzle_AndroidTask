package com.dubizzle.data.repository

import com.dubizzle.data.model.ListingsData
import io.reactivex.Observable


interface LocalDataSource {
    fun getListings(limit: Int): Observable<List<ListingsData>>
    fun getListingsByID(uid: String): Observable<ListingsData>
    fun saveListings(listings: List<ListingsData>)

}