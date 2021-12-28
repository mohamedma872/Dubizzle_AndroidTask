package com.dubizzle.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dubizzle.domain.repository.ListingsRepository
import com.dubizzle.domain.usecases.GetListingsTask
import com.dubizzle.presentation.mapper.ListingsEntityMapper
import com.dubizzle.presentation.model.Status
import com.dubizzle.presentation.utils.TestDataGenerator
import com.dubizzle.presentation.viewmodel.HomeViewModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class HomeViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: ListingsRepository

    private lateinit var homeVM: HomeViewModel
    private val listingsMapper = ListingsEntityMapper()

    private val listings = TestDataGenerator.generateListings()
    private val listingsEntities =
        listings.map { listingsMapper.from(it) }

    @Before
    fun setup() {
        val limit = 20
        MockitoAnnotations.initMocks(this)

        Mockito.`when`(repository.getListings(limit))
            .thenReturn(Observable.just(listingsEntities))

        val getListingsTask = getListings()

        homeVM = HomeViewModel(

            listingsMapper,
            getListingsTask,
        )
    }
    @Test
    fun test_getListings_success() {
        val limit = 20
        Mockito.`when`(
            repository.getListings(limit)
        ).thenReturn(Observable.just(listingsEntities))

        val listingsListSource = homeVM.listingsResource

        listingsListSource.observeForever { /*Do Nothing*/ }

        Assert.assertTrue(
            listingsListSource.value?.status == Status.SUCCESS
                    && listingsListSource.value?.data == listings
        )
    }

    @Test
    fun test_getListings_error() {
        val limit = 20
        val errorMsg = "fetch transaction error"

        Mockito.`when`(
            repository.getListings(limit)
        ).thenReturn(Observable.error(Throwable(errorMsg)))

        val listingsListSource = homeVM.listingsResource

        listingsListSource.observeForever { /*Do Nothing*/ }

        Assert.assertTrue(
            listingsListSource.value?.status == Status.ERROR
                    && listingsListSource.value?.message == errorMsg
        )
    }
    //=====================================//
    // Helper methods for use case creation//
    //=====================================//
    private fun getListings(): GetListingsTask {
        return GetListingsTask(
            repository,
            Schedulers.trampoline(),
            Schedulers.trampoline()
        )
    }
}