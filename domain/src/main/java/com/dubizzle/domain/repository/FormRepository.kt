package com.dubizzle.domain.repository

import com.dubizzle.domain.entities.FormEntity
import io.reactivex.Observable

// FIXME: All Params and return types should be changed
interface FormRepository {

    fun submitFormData(mediaType: String, timeWindow: String): Observable<FormEntity> //call remote requests

    fun fetchInQueueCalls(): Observable<List<FormEntity>>

    fun syncInQueueCallsToRemote(input: Observable<List<FormEntity>>?): Observable<List<FormEntity>> //trigger all calls in queue
}