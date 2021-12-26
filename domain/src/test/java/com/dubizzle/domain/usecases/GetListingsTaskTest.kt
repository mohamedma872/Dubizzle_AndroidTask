package com.dubizzle.domain.usecases

import com.dubizzle.domain.repository.ListingsRepository
import com.dubizzle.domain.utils.TestDataGenerator
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class GetListingsTaskTest {

    private lateinit var getUserTransactionsTask: GetListingsTask
    @Mock
    lateinit var listingsRepository: ListingsRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getUserTransactionsTask = GetListingsTask(
            listingsRepository,
            Schedulers.trampoline(),
            Schedulers.trampoline()
        )
    }

    @Test
    fun test_getListings_success() {

        val listings = TestDataGenerator.generateListings()

        Mockito.`when`(listingsRepository.getListings())
            .thenReturn(Observable.just(listings))

        val testObserver = getUserTransactionsTask.buildUseCase().test()

        testObserver
            .assertSubscribed()
            .assertValue { it.containsAll(listings) }
    }

    @Test
    fun test_getListings_error() {

        val errorMsg = "ERROR OCCURRED"

        Mockito.`when`(listingsRepository.getListings())
            .thenReturn(Observable.error(Throwable(errorMsg)))

        val testObserver = getUserTransactionsTask.buildUseCase().test()

        testObserver
            .assertSubscribed()
            .assertError { it.message?.equals(errorMsg, false) ?: false }
            .assertNotComplete()
    }

}