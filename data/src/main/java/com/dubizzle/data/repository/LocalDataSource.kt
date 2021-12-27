package com.dubizzle.data.repository

import com.dubizzle.data.model.ListingsData
import io.reactivex.Observable


interface LocalDataSource {
    fun getListings(): Observable<List<ListingsData>>
    fun saveListings(transactions: List<ListingsData>)

}