package com.dubizzle.data.repository

import com.dubizzle.data.model.ListingsData
import io.reactivex.Observable

interface RemoteDataSource {
    suspend fun getListings(limit: Int): List<ListingsData>
}