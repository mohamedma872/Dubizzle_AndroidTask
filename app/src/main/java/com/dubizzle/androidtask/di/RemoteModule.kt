package com.dubizzle.androidtask.di

import com.dubizzle.androidtask.BuildConfig
import com.dubizzle.data.model.ListingsData
import com.dubizzle.data.repository.RemoteDataSource
import com.dubizzle.remote.api.ListingsService
import com.dubizzle.remote.mapper.ListingsDataNetworkMapper
import com.dubizzle.remote.mapper.Mapper
import com.dubizzle.remote.model.ListingsNetwork
import com.dubizzle.remote.source.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [RemoteModule.Binders::class])
@InstallIn(SingletonComponent::class)
class RemoteModule {
    @InstallIn(SingletonComponent::class)
    @Module
    interface Binders {

        @Binds
        fun bindsRemoteSource(
            remoteDataSourceImpl: RemoteDataSourceImpl
        ): RemoteDataSource

        @Binds
        fun bindListingsMapper(
            listingsMapper: ListingsDataNetworkMapper
        ): Mapper<ListingsData, ListingsNetwork>


    }

    @Provides
    fun providesListingsService(retrofit: Retrofit): ListingsService =
        retrofit.create(ListingsService::class.java)


    @Provides
    fun providesRetrofit(): Retrofit =
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()


}