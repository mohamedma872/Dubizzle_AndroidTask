package com.dubizzle.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calls_table")
data class FormLocal(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "formId")
    val id: Int?,
    @ColumnInfo(name = "mediaType")
    val mediaType: String? = null,
    @ColumnInfo(name = "timeWindow")
    val timeWindow: String? = null,
    @ColumnInfo(name = "successStatus")
    val successStatus: Boolean? = null
)