package com.dubizzle.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.dubizzle.domain.entities.FormEntity
import com.dubizzle.domain.usecases.form.FetchInQueueCallsTask
import com.dubizzle.domain.usecases.form.SubmitFormTask
import com.dubizzle.domain.usecases.form.SyncInQueueCallsToRemoteTask
import com.dubizzle.presentation.mapper.Mapper
import com.dubizzle.presentation.model.Form
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class FormViewModel @Inject internal constructor(
    private val formMapper: Mapper<FormEntity, Form>,
    private val fetchInQueueCallsTask: FetchInQueueCallsTask,
    private val submitFormTask: SubmitFormTask,
    private val syncInQueueCallsTask: SyncInQueueCallsToRemoteTask,
) : ViewModel() {

    private val disposables = CompositeDisposable()

    // live data of resource of Listings class that will be consumed by the UI
    //TODO("not implemented")

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }



}