package com.dubizzle.domain.usecases.base

import io.reactivex.Observable
import io.reactivex.Scheduler

/**
ObservableUseCase use two generic types
@param backgroundScheduler , foregroundScheduler it expects two Scheduler in the constructor for Scheduling.
@param T is the input type
@return the value returned by the method
@throws what kind of exception does this method throw
 */
abstract class ObservableUseCase<T> constructor(
    private val backgroundScheduler: Scheduler,
    private val foregroundScheduler: Scheduler
) {
    protected abstract fun generateObservable(): Observable<T>

    fun buildUseCase(): Observable<T> {
        return generateObservable()
            .subscribeOn(backgroundScheduler)
            .observeOn(foregroundScheduler)
    }

}