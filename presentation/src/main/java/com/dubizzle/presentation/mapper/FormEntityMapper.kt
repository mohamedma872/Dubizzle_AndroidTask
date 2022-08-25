package com.dubizzle.presentation.mapper

import com.dubizzle.domain.entities.FormEntity
import com.dubizzle.presentation.model.Form
import javax.inject.Inject

class FormEntityMapper @Inject constructor() : Mapper<FormEntity, Form> {
    override fun from(e: Form): FormEntity {
        return FormEntity(
            mediaType = e.mediaType,
            timeWindow = e.timeWindow,
            successStatus = e.successStatus
        )
    }

    override fun to(t: FormEntity): Form {
        return Form(
            mediaType = t.mediaType,

            timeWindow = t.timeWindow,

            successStatus = t.successStatus
        )
    }
}