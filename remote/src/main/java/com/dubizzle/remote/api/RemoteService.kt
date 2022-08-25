package com.dubizzle.remote.api

import com.dubizzle.remote.model.ResponseWrapper
import com.dubizzle.remote.model.TrendingRemote
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface RemoteService {

    @GET("https://api.themoviedb.org/3/trending/{media_type}/{time_window}")
    fun getTrending(
        @Path("media_type") mediaType: String?,
        @Path("time_window") timeWindow: String?
    ):Observable<Response<TrendingRemote>>

}