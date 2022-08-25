package com.dubizzle.domain.usecases.form

import com.dubizzle.domain.entities.FormEntity
import com.dubizzle.domain.qualifiers.Background
import com.dubizzle.domain.qualifiers.Foreground
import com.dubizzle.domain.repository.FormRepository
import com.dubizzle.domain.usecases.base.ObservableUseCase
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject

class SubmitFormTask @Inject constructor(
    private val formRepository: FormRepository,
    @Background backgroundScheduler: Scheduler,
    @Foreground foregroundScheduler: Scheduler):
    ObservableUseCase<FormEntity, SubmitFormTask.Params>(
    backgroundScheduler,
    foregroundScheduler
) {

    override fun generateObservable(input: Params?): Observable<FormEntity> {
        if (input == null) {
            throw IllegalArgumentException("GetListingsTask parameter can't be null")
        }
        return formRepository.submitFormData(input.mediaType,input.timeWindow)
    }
    data class Params(
        val mediaType: String,
        val timeWindow: String
    )

}

