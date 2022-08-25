package com.dubizzle.data.repository.form

import com.dubizzle.data.model.FormData
import io.reactivex.Completable
import io.reactivex.Observable


interface FormLocalDataSource {

    fun addFormData(items: FormData): Completable

    fun updateFormData(uid: Int): Completable

    fun syncFailedCalls(): Observable<List<FormData>>

    fun getAllCalls(): Observable<List<FormData>>

    fun deleteFormData(uid: Int): Completable

}
