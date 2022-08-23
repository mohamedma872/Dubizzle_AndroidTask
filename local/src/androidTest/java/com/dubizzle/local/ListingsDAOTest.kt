package com.dubizzle.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.dubizzle.local.database.ListingsDAO
import com.dubizzle.local.database.ListingsDB
import com.dubizzle.local.utils.TestData
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ListingsDAOTest {
    private lateinit var listingsDB: ListingsDB
    private lateinit var listingsDAO: ListingsDAO

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        listingsDB = Room.inMemoryDatabaseBuilder(context, ListingsDB::class.java)
            .allowMainThreadQueries()
            .build()

        listingsDAO = listingsDB.getListingsDao()
    }

    @After
    fun tearDown() {
        listingsDAO.clearCachedTransactions().subscribe()
        listingsDB.close()
    }
    @Test
    suspend fun test_saveAndRetrieveUserListings() {

        val listings = TestData.generateListings()
        val listingsCount = listings.size

        listingsDAO.addListings(listings)

        listingsDAO.getListings(20)
            .test()
            .assertValue {
                listings.containsAll(it)
                        && it.size == listingsCount
            }.assertNotComplete() // As Room Observables are kept alive
    }

    @Test
    suspend fun test_clearCachedListings() {
        val limit = 40
        val listings = TestData.generateListings()

        listingsDAO.addListings(listings)

        listingsDAO.getListings(limit)
            .test()
            .assertValue {
                it.size == listings.size
            }

        listingsDAO.clearCachedTransactions().subscribe()

        listingsDAO.getListings(limit)
            .test()
            .assertValue { it.isEmpty() }
    }
}