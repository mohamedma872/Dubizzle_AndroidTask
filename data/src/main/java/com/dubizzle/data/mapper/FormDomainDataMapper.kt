package com.dubizzle.data.mapper

import com.dubizzle.data.model.FormData
import com.dubizzle.domain.entities.FormEntity
import javax.inject.Inject

class FormDomainDataMapper @Inject constructor() : Mapper<FormEntity, FormData> {

    override fun from(e: FormData): FormEntity {
        return FormEntity(
            mediaType = e.mediaType,
            timeWindow = e.timeWindow,
            successStatus = e.successStatus,
        )
    }

    override fun to(t: FormEntity): FormData {
        return FormData(
            mediaType = t.mediaType,
            timeWindow = t.timeWindow,
            successStatus = t.successStatus,
        )
    }
}