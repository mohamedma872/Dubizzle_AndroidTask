package com.dubizzle.androidtask.di

import android.content.Context
import com.dubizzle.data.model.ListingsData
import com.dubizzle.data.repository.LocalDataSource
import com.dubizzle.local.database.ListingsDB
import com.dubizzle.local.mapper.ListingsDataLocalMapper
import com.dubizzle.local.mapper.Mapper
import com.dubizzle.local.model.ListingsLocal
import com.dubizzle.local.source.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [LocalPersistenceModule.Binders::class])
@InstallIn(SingletonComponent::class)
class LocalPersistenceModule {

    @Module
    @InstallIn(SingletonComponent::class)
    interface Binders {
        @Binds
        fun bindsLocalDataSource(
            localDataSourceImpl: LocalDataSourceImpl
        ): LocalDataSource


        @Binds
        fun bindListingsMapper(
            listingsMapper: ListingsDataLocalMapper
        ): Mapper<ListingsData, ListingsLocal>
    }
    @Provides
    @Singleton
    //provide application context using hilt's @ApplicationContext
    fun providesDatabase(
        @ApplicationContext context: Context
    ) = ListingsDB.getInstance(context)

    @Provides
    @Singleton
    fun providesListingsDAO(
        listingsDB: ListingsDB
    ) = listingsDB.getListingsDao()

}
