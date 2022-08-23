package com.dubizzle.domain.repository

import com.dubizzle.domain.entities.ListingsEntity
import io.reactivex.Observable

interface ListingsRepository {
    suspend fun getListings(limit: Int): List<ListingsEntity>
}