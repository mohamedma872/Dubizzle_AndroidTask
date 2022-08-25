package com.dubizzle.local.source

import com.dubizzle.data.model.FormData
import com.dubizzle.data.repository.form.FormLocalDataSource
import com.dubizzle.local.database.FormDAO
import com.dubizzle.local.mapper.FormDataLocalMapper
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class FormLocalDataSourceImpl @Inject constructor(
    private val formMapper: FormDataLocalMapper,
    private val formDAO: FormDAO
) : FormLocalDataSource {
    override fun addFormData(items: FormData): Completable {
        return formDAO.addFormData(formMapper.to(items))
    }

    override fun updateFormData(uid: Int): Completable {
        return formDAO.updateToSuccessFormData(uid)
    }

    override fun syncFailedCalls(): Observable<List<FormData>> {
        return formDAO.syncFailedCalls().map {
            it.map { formLocal ->  formMapper.from(formLocal) }
        }
    }

    override fun getAllCalls(): Observable<List<FormData>> {
        return formDAO.getAllCalls().map {
            it.map { formLocal -> formMapper.from(formLocal) }
        }
    }

    override fun deleteFormData(uid: Int): Completable {
        return formDAO.deleteFormData(uid)
    }
}
