package com.dubizzle.androidtask.utils

import com.dubizzle.remote.api.ListingsService
import com.dubizzle.remote.model.ResponseWrapper
import com.google.gson.Gson
import io.reactivex.Observable

class FakeListingsService : ListingsService {
    override fun getListings(
    ): Observable<ResponseWrapper> {
        val responseWrapper = Gson()
            .fromJson(testData, ResponseWrapper::class.java)
        return Observable.just(responseWrapper)
    }
}