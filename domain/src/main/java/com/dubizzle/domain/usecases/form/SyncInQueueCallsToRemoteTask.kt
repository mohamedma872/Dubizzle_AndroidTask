package com.dubizzle.domain.usecases.form

import com.dubizzle.domain.entities.FormEntity
import com.dubizzle.domain.qualifiers.Background
import com.dubizzle.domain.qualifiers.Foreground
import com.dubizzle.domain.repository.FormRepository
import com.dubizzle.domain.usecases.base.ObservableUseCase
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject

class SyncInQueueCallsToRemoteTask @Inject constructor(
    private val formRepository: FormRepository,
    @Background backgroundScheduler: Scheduler,
    @Foreground foregroundScheduler: Scheduler
) :
    ObservableUseCase<List<FormEntity>, SyncInQueueCallsToRemoteTask.Args>(
        backgroundScheduler,
        foregroundScheduler
    ) {

    // TODO: To be checked if this is the correct way to do it
    override fun generateObservable(input: Args?): Observable<List<FormEntity>> {
        if (input == null) {
            throw IllegalArgumentException("SyncInQueueCallsToRemoteTask parameter can't be null")
        }
        return formRepository.syncInQueueCallsToRemote(input.failedCalls)
    }

    data class Args(val failedCalls: Observable<List<FormEntity>>? = null)
}

