package com.dubizzle.presentation.viewmodel

import androidx.lifecycle.*
import com.dubizzle.domain.entities.ListingsEntity
import com.dubizzle.domain.usecases.GetListingsTask
import com.dubizzle.presentation.mapper.Mapper
import com.dubizzle.presentation.model.Listings
import com.dubizzle.presentation.model.Resource
import kotlinx.coroutines.*
import javax.inject.Inject


// i injected all the required dependencies via constructor
class HomeViewModel @Inject internal constructor(
    private val listingsMapper: Mapper<ListingsEntity, Listings>,
    private val getListingsTask: GetListingsTask,
) : ViewModel() {

init {
    getData()
}
    // live data of resource of Listings class that will be consumed by the UI
    private val _listingsResource = MutableLiveData<Resource<List<Listings>>>()
    val listingsResource : MutableLiveData<Resource<List<Listings>>> = _listingsResource

    private fun getData() {
            viewModelScope.launch(Dispatchers.IO){

                _listingsResource.postValue(Resource.success(
                    getListingsTask
                        // it's basically build the UseCase
                        .buildUseCase(GetListingsTask.Params(20))
                        // it map the data to an acceptable format using the injected mapper
                        .map { transactionEntities ->
                            listingsMapper.to(transactionEntities)
                        }
                )
                )
            }
    }
}