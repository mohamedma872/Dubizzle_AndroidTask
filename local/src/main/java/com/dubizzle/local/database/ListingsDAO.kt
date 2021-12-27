package com.dubizzle.local.database

import androidx.room.*
import com.dubizzle.local.model.ListingsLocal
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface ListingsDAO {
    @Query("SELECT * FROM listings ORDER BY createdAt DESC LIMIT :limit")
    fun getListings(limit: Int): Observable<List<ListingsLocal>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addListings(items: List<ListingsLocal>)

    @Query("SELECT * FROM listings WHERE uid = :uid")
    fun listingsById(uid: String): Observable<ListingsLocal>

    @Query("DELETE FROM listings")
    fun clearCachedTransactions(): Completable
}