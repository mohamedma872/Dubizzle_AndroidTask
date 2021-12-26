package com.dubizzle.domain.usecases

import com.dubizzle.domain.entities.ListingsEntity
import com.dubizzle.domain.qualifiers.Background
import com.dubizzle.domain.qualifiers.Foreground
import com.dubizzle.domain.repository.ListingsRepository
import com.dubizzle.domain.usecases.base.ObservableUseCase
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject

class GetListingsTask @Inject constructor(
    private val listingsRepository: ListingsRepository,
    @Background backgroundScheduler: Scheduler,
    @Foreground foregroundScheduler: Scheduler
) : ObservableUseCase<List<ListingsEntity>>(
    backgroundScheduler,
    foregroundScheduler
) {
    override fun generateObservable(): Observable<List<ListingsEntity>> {

        return listingsRepository.getListings()
    }
}