package com.dubizzle.remote.api

import com.dubizzle.remote.model.ResponseWrapper
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ListingsService {

    @GET("default/dynamodb-writer")
    suspend fun getListings() :Response<ResponseWrapper>
}