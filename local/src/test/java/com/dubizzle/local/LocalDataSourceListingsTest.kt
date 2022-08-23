package com.dubizzle.local

import com.dubizzle.data.repository.LocalDataSource
import com.dubizzle.local.database.ListingsDAO
import com.dubizzle.local.mapper.ListingsDataLocalMapper
import com.dubizzle.local.source.LocalDataSourceImpl
import com.dubizzle.local.utils.TestDataGenerator
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class LocalDataSourceListingsTest {

    private val listingsMapper = ListingsDataLocalMapper()


    @Mock
    private lateinit var listingsDAO: ListingsDAO

    private lateinit var localDataSource: LocalDataSource

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        localDataSource = LocalDataSourceImpl(
            listingsMapper,
            listingsDAO
        )
    }

    @Test
    fun test_getListings_success() {
        val limit = 20
        val mockListings = TestDataGenerator.generateListings()

        Mockito.`when`(listingsDAO.getListings(limit))
            .thenReturn(Observable.just(mockListings))

        localDataSource.getListings( limit)
            .test()
            .assertSubscribed()
            .assertValue { items ->
                mockListings.containsAll(
                    items.map {
                        listingsMapper.to(it)
                    }
                )
            }
    }

    @Test
    suspend fun test_saveListings_success() {
        val mockTransactions = TestDataGenerator.generateListings()

        localDataSource.saveListings(

            mockTransactions.map {
                listingsMapper.from(it)
            }
        )

        Mockito.verify(listingsDAO, times(1))
            .addListings(mockTransactions)
    }

    @Test
    fun test_getTransactionById_success() {
        val mockListings = TestDataGenerator.generateListings()[0]
        val listingsId = mockListings.uid

        Mockito.`when`(listingsDAO.listingsById(listingsId))
            .thenReturn(Observable.just(mockListings))

        localDataSource.getListingsByID(listingsId)
            .test()
            .assertSubscribed()
            .assertValue {
                mockListings == listingsMapper.to(it)
            }
    }

    @Test
    fun test_getTransactionById_error() {
        val listingsId = "4878bf592579410fba52941d00b62f94"
        val errorMsg = "ERROR"
        Mockito.`when`(listingsDAO.listingsById(listingsId))
            .thenReturn(Observable.error(Throwable(errorMsg)))

        localDataSource.getListingsByID(listingsId)
            .test()
            .assertSubscribed()
            .assertError {
                it.message == errorMsg
            }
            .assertNotComplete()
    }



}
