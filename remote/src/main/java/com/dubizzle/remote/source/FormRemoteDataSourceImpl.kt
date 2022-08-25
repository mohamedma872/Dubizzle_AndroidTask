package com.dubizzle.remote.source

import com.dubizzle.data.model.FormData
import com.dubizzle.data.repository.form.FormRemoteDataSource
import com.dubizzle.remote.api.RemoteService
import io.reactivex.Observable
import javax.inject.Inject

class FormRemoteDataSourceImpl @Inject constructor(
    private val remoteService: RemoteService
) : FormRemoteDataSource {

    override fun submitFormData(
        mediaType: String,
        timeWindow: String
    ): Observable<FormData> {

        return remoteService.getTrending(mediaType, timeWindow)
            .map {
               when(it.isSuccessful){
                   false-> FormData(
                       mediaType = mediaType,
                       timeWindow = timeWindow,
                       successStatus = false
                   )
                   else -> FormData(
                       mediaType = mediaType,
                       timeWindow = timeWindow,
                       successStatus = true
                   )
               }
            }
    }
}
