package com.dubizzle.local.database

import android.content.Context
import androidx.annotation.NonNull
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dubizzle.local.model.FormLocal
import com.dubizzle.local.model.ListingsLocal

@Database(
    entities = [ListingsLocal::class,FormLocal::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class ListingsDB : RoomDatabase() {

    companion object {
        private val LOCK = Any()
        private const val DATABASE_NAME = "listings.db"

        @Volatile
        private var INSTANCE: ListingsDB? = null

        fun getInstance(@NonNull context: Context): ListingsDB {
            if (INSTANCE == null) {
                synchronized(LOCK) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context,
                            ListingsDB::class.java,
                            DATABASE_NAME
                        ).build()
                    }
                }
            }
            return INSTANCE!!
        }
    }

    abstract fun getListingsDao(): ListingsDAO

    abstract fun getFormDao(): FormDAO


}

