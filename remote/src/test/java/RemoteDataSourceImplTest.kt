import com.dubizzle.data.repository.RemoteDataSource
import com.dubizzle.remote.api.ListingsService
import com.dubizzle.remote.mapper.ListingsDataNetworkMapper
import com.dubizzle.remote.model.ResponseWrapper
import com.dubizzle.remote.source.RemoteDataSourceImpl
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import utils.TestDataGenerator

@RunWith(JUnit4::class)
class RemoteDataSourceImplTest {

    @Mock
    private lateinit var listingsService: ListingsService

    private val listingsMapper = ListingsDataNetworkMapper()

    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        remoteDataSource = RemoteDataSourceImpl(
            listingsMapper,
            listingsService
        )
    }


    @Test
    fun test_getListings_success() {
        val listings = TestDataGenerator.generateListings()
        val limit = 10

        val mockResponse = ResponseWrapper(
            null,
            listings
        )

        Mockito.`when`(listingsService.getListings())
            .thenReturn(Observable.just(mockResponse))

        remoteDataSource.getListings(limit)
            .test()
            .assertSubscribed()
            .assertValue { transactionsList ->
                transactionsList.containsAll(
                    listings.map { listingsMapper.from(it) }
                )
            }
            .assertComplete()
    }

    @Test
    fun test_getUserTransactions_error() {
        val userIdentifier = "4878bf592579410fba52941d00b62f94"
        val errorMsg = "ERROR"
        val limit = 10

        Mockito.`when`(listingsService.getListings())
            .thenReturn(Observable.error(Throwable(errorMsg)))

        remoteDataSource.getListings(limit)
            .test()
            .assertSubscribed()
            .assertError {
                it.message == errorMsg
            }
            .assertNotComplete()
    }

}