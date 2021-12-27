import com.dubizzle.data.mapper.ListingsDomainDataMapper
import com.dubizzle.data.repository.ListingsRepositoryImpl
import com.dubizzle.data.repository.LocalDataSource
import com.dubizzle.data.repository.RemoteDataSource
import com.dubizzle.domain.repository.ListingsRepository
import io.reactivex.Completable
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations
import utils.TestDataGenerator

@RunWith(JUnit4::class)
class RepositoryImplementationTest {

    private lateinit var listingsRepository: ListingsRepository

    private val listingsMapper = ListingsDomainDataMapper()


    @Mock
    private lateinit var remoteDataSource: RemoteDataSource
    @Mock
    private lateinit var localDataSource: LocalDataSource

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        listingsRepository = ListingsRepositoryImpl(
            listingsMapper,
            localDataSource,
            remoteDataSource
        )
    }

    @Test
    fun test_getListings_local_remote_interactions() {

        val listingsData = TestDataGenerator.generateListings()

        Mockito.`when`(remoteDataSource.getListings())
            .thenReturn(Observable.just(listingsData))
        Mockito.`when`(localDataSource.getListings())
            .thenReturn(Observable.just(listingsData))

        val testSubscriber = listingsRepository.getListings().test()

        testSubscriber.assertSubscribed()
            .assertValues(
                listingsData.map { listingsMapper.from(it) },
                listingsData.map { listingsMapper.from(it) }
            )
            .assertComplete()

        Mockito.verify(localDataSource, times(1))
            .saveListings( listingsData)

        Mockito.verify(remoteDataSource, times(1))
            .getListings()
    }

    @Test
    fun test_getListings_remote_error() {
        val listingsData = TestDataGenerator.generateListings()

        Mockito.`when`(remoteDataSource.getListings())
            .thenReturn(Observable.error(Throwable()))
        Mockito.`when`(localDataSource.getListings())
            .thenReturn(Observable.just(listingsData))

        val testSubscriber = listingsRepository.getListings().test()

        testSubscriber.assertSubscribed()
            .assertValue { transactions ->
                transactions.containsAll(listingsData.map {
                    listingsMapper.from(it)
                })
            }
            .assertComplete()

        Mockito.verify(localDataSource, times(1))
            .getListings()
    }
}