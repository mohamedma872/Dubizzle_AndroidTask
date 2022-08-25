package com.dubizzle.data.repository.form

import com.dubizzle.data.mapper.Mapper
import com.dubizzle.data.model.FormData
import com.dubizzle.domain.entities.FormEntity
import com.dubizzle.domain.repository.FormRepository
import io.reactivex.Observable
import javax.inject.Inject

// @Inject lets Dagger know how to create instances of this object
class FormRepositoryImpl @Inject constructor(
    private val formMapper: Mapper<FormEntity, FormData>,
    private val localDataSource: FormLocalDataSource,
    private val remoteDataSource: FormRemoteDataSource
) : FormRepository {

    override fun submitFormData(mediaType: String, timeWindow: String): Observable<FormEntity> {
         return remoteDataSource.submitFormData(mediaType, timeWindow)
            .filter {
                it.successStatus == false }
            .doOnNext { localDataSource.addFormData(it) }
            .map {
                formMapper.from(it) }
            .onErrorResumeNext(Observable.empty())
    }

    /*
        Fetch failed calls from local storage
     */
    override fun fetchInQueueCalls(): Observable<List<FormEntity>> {

        return localDataSource.syncFailedCalls()
            .map { listFormData ->
                listFormData.map {
                formMapper.from(it) }
        }
    }
    // retry failed calls from remote

    override fun syncInQueueCallsToRemote(input: Observable<List<FormEntity>>?): Observable<List<FormEntity>> {
        TODO("Not yet implemented")
    }

    //TODO(update local storage after successful calls )


}