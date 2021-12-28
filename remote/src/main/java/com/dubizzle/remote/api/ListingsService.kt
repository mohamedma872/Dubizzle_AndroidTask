package com.dubizzle.remote.api

import com.dubizzle.remote.model.ResponseWrapper
import io.reactivex.Observable
import retrofit2.http.GET

interface ListingsService {

    @GET("default/dynamodb-writer")
    fun getListings():
            Observable<ResponseWrapper>
}