package com.dubizzle.androidtask.di

import android.app.Application
import com.dubizzle.data.model.FormData
import com.dubizzle.data.model.ListingsData
import com.dubizzle.data.repository.LocalDataSource
import com.dubizzle.data.repository.form.FormLocalDataSource
import com.dubizzle.local.database.ListingsDB
import com.dubizzle.local.mapper.FormDataLocalMapper
import com.dubizzle.local.mapper.ListingsDataLocalMapper
import com.dubizzle.local.mapper.Mapper
import com.dubizzle.local.model.FormLocal
import com.dubizzle.local.model.ListingsLocal
import com.dubizzle.local.source.FormLocalDataSourceImpl
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
            listingsMapper: ListingsDataLocalMapper
        ): Mapper<ListingsData, ListingsLocal>

        @Binds
        fun bindsFormLocalDataSource(
            formLocalDataSourceImpl: FormLocalDataSourceImpl
        ): FormLocalDataSource


        @Binds
        fun bindFormMapper(
            formMapper: FormDataLocalMapper
        ): Mapper<FormData, FormLocal>
    }

    @Provides
    @Singleton
    fun providesDatabase(
        application: Application
    ) = ListingsDB.getInstance(application.applicationContext)



    @Provides
    @Singleton
    fun providesListingsDAO(
        listingsDB: ListingsDB
    ) = listingsDB.getListingsDao()

    @Provides
    @Singleton
    fun providesFormDAO(
        listingsDB: ListingsDB
    ) = listingsDB.getFormDao()
}
