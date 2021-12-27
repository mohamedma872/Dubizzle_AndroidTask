package com.dubizzle.data.repository

import com.dubizzle.data.model.ListingsData
import io.reactivex.Observable

interface RemoteDataSource {
    fun getListings(): Observable<List<ListingsData>>
}