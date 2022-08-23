package com.dubizzle.domain.usecases

import com.dubizzle.domain.entities.ListingsEntity
import com.dubizzle.domain.repository.ListingsRepository
import com.dubizzle.domain.usecases.base.GetItemsListUseCase
import javax.inject.Inject

class GetListingsTask @Inject constructor(
    private val listingsRepository: ListingsRepository,
) : GetItemsListUseCase<List<ListingsEntity>, GetListingsTask.Params>() {
    override suspend fun generateObservable(input: Params?): List<ListingsEntity> {
        if (input == null) {
            throw IllegalArgumentException("GetListingsTask parameter can't be null")
        }
        return listingsRepository.getListings(input.limit)
    }
    data class Params( val limit: Int)
}
