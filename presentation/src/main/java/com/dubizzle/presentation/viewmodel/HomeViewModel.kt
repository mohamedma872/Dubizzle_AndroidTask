package com.dubizzle.presentation.viewmodel

import androidx.lifecycle.*
import com.dubizzle.domain.entities.ListingsEntity
import com.dubizzle.domain.usecases.GetListingsTask
import com.dubizzle.presentation.mapper.Mapper
import com.dubizzle.presentation.model.Listings
import com.dubizzle.presentation.model.Resource
import com.dubizzle.presentation.model.Status
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import javax.inject.Inject

// i injected all the required dependencies via constructor
class HomeViewModel @Inject internal constructor(
    private val listingsMapper: Mapper<ListingsEntity, Listings>,
    private val getListingsTask: GetListingsTask,
) : ViewModel() {


    private val disposables = CompositeDisposable()

    // live data of resource of Listings class that will be consumed by the UI
    val listingsResource : LiveData<Resource<List<Listings>>>
        get() = getListingsTask
        // it's basically build the UseCase
        .buildUseCase()
        // it map the data to an acceptable format using the injected mapper
        .map { transactionEntities ->
            transactionEntities.map {
                listingsMapper.to(it)
            }
        // finally it creates a Resource object based on completion , loading and an error state that's repesent the single state of home screen
        }.map { Resource.success(it) }
        .startWith(Resource.loading())
        .onErrorResumeNext(Function {
            Observable.just(
                Resource.error(it.localizedMessage ?: "")
            )
        }).toFlowable(BackpressureStrategy.LATEST)
        // we then convert the RX observable to live data using the extension function of LiveDataReactiveStream
        .toLiveData()


    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

}