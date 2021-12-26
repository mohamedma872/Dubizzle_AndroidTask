package com.dubizzle.domain.usecases.base

import io.reactivex.Scheduler
import io.reactivex.Single


/**
SingleUseCase use two generic types
@param backgroundScheduler , foregroundScheduler it expects two Scheduler in the constructor for Scheduling.
@param T is the input type
@return the value returned by the method
@throws what kind of exception does this method throw
 */
abstract class SingleUseCase<T> constructor(
    private val backgroundScheduler: Scheduler,
    private val foregroundScheduler: Scheduler
) {
    protected abstract fun generateSingle(): Single<T>

    fun buildUseCase(): Single<T> {
        return generateSingle()
            .subscribeOn(backgroundScheduler)
            .observeOn(foregroundScheduler)
    }

}