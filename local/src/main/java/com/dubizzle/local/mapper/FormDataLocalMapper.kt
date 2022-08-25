package com.dubizzle.local.mapper

import com.dubizzle.data.model.FormData
import com.dubizzle.local.model.FormLocal
import javax.inject.Inject

class FormDataLocalMapper @Inject constructor() : Mapper<FormData, FormLocal> {

    override fun from(e: FormLocal): FormData {
        return FormData(
            mediaType = e.mediaType,
            timeWindow = e.timeWindow,
            successStatus = e.successStatus
        )
    }

    override fun to(t: FormData): FormLocal {
        return FormLocal(
            id = null,
            mediaType = t.mediaType,
            timeWindow = t.timeWindow,
            successStatus = t.successStatus
        )
    }
}