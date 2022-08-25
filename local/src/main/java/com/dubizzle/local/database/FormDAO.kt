package com.dubizzle.local.database

import androidx.room.*
import com.dubizzle.data.model.FormData
import com.dubizzle.local.model.FormLocal
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface FormDAO {

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        fun addFormData(items: FormLocal): Completable

        @Query("UPDATE calls_table SET successStatus = '1' WHERE formId = :uid")
        fun updateToSuccessFormData(uid: Int): Completable

        @Query("SELECT * FROM calls_table WHERE successStatus = '0'")
        fun syncFailedCalls(): Observable<List<FormLocal>>

        @Query("SELECT * FROM calls_table")
        fun getAllCalls(): Observable<List<FormLocal>>

        @Query("DELETE FROM calls_table WHERE formId = :uid")
        fun deleteFormData(uid: Int): Completable

}
