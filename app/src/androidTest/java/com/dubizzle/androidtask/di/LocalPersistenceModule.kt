package com.dubizzle.androidtask.di

import android.app.Application
import androidx.room.Room
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

import javax.inject.Singleton

@Module(includes = [LocalPersistenceModule.Binders::class])
class LocalPersistenceModule {

    @Module
    interface Binders {

        @Binds
        fun bindsLocalDataSource(
            localDataSourceImpl: LocalDataSourceImpl
        ): LocalDataSource


        @Binds
        fun bindListingsMapper(
            transactionMapper: ListingsDataLocalMapper
        ): Mapper<ListingsData, ListingsLocal>
    }

    @Provides
    @Singleton
    fun providesDatabase(
        application: Application
    ) = Room.inMemoryDatabaseBuilder(application, ListingsDB::class.java)
        .allowMainThreadQueries()
        .build()


    @Provides
    @Singleton
    fun providesListingsDAO(
        listingsDB: ListingsDB
    ) = listingsDB.getListingsDao()

}
