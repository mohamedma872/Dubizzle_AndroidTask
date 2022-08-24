package com.dubizzle.domain.usecases.base

import com.dubizzle.domain.entities.ListingsEntity
import io.reactivex.Observable
import io.reactivex.Scheduler
import kotlin.coroutines.CoroutineContext

/**
ObservableUseCase use two generic types
@param backgroundScheduler , foregroundScheduler it expects two Scheduler in the constructor for Scheduling.
@param T is the input type
@param Input is the parameter type
@return the value returned by the method
@throws what kind of exception does this method throw
 */

abstract class GetItemsListUseCase<T, in Input> {
    protected abstract suspend fun generateObservable(input: Input? = null): T

    suspend fun buildUseCase(input: Input? = null): T {
        return generateObservable(input)
    }
}