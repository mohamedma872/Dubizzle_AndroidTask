package com.dubizzle.data.repository

import com.dubizzle.data.mapper.Mapper
import com.dubizzle.data.model.ListingsData
import com.dubizzle.domain.entities.ListingsEntity
import com.dubizzle.domain.repository.ListingsRepository
import io.reactivex.Observable
import javax.inject.Inject

class ListingsRepositoryImpl @Inject constructor(
    private val listingsMapper: Mapper<ListingsEntity, ListingsData>,
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : ListingsRepository {
    override fun getListings(): Observable<List<ListingsEntity>> {

        val localListings = localDataSource.getListings()
            .map { listings ->
                listings.map { listingsMapper.from(it) }
            }

        return remoteDataSource.getListings()
            .map { listings ->
                localDataSource.saveListings(listings)
                listings.map { listingsMapper.from(it) }
            }.onErrorResumeNext(Observable.empty())
            .concatWith(localListings)
    }
}