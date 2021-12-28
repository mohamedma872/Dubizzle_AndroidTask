package com.dubizzle.androidtask.di

import com.dubizzle.data.mapper.ListingsDomainDataMapper
import com.dubizzle.data.mapper.Mapper
import com.dubizzle.data.model.ListingsData
import com.dubizzle.data.repository.ListingsRepositoryImpl
import com.dubizzle.domain.entities.ListingsEntity
import com.dubizzle.domain.repository.ListingsRepository
import dagger.Binds
import dagger.Module


@Module
abstract class DataModule {

    // This annotation provides a replacement of @Provides methods which simply return the injected parameter
    @Binds
    abstract fun bindsRepository(
        repoImpl: ListingsRepositoryImpl
    ): ListingsRepository

    // This annotation provides a replacement of @Provides methods which simply return the injected parameter
    @Binds
    abstract fun bindsListingsMapper(
        mapper: ListingsDomainDataMapper
    ): Mapper<ListingsEntity, ListingsData>
}