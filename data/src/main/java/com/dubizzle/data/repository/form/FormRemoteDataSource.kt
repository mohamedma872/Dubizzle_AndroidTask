package com.dubizzle.data.repository.form

import com.dubizzle.data.model.FormData
import io.reactivex.Observable

interface FormRemoteDataSource {
    fun submitFormData(mediaType: String, timeWindow: String): Observable<FormData>
}