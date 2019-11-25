package happy.mjstudio.paging.domain.datasource

import androidx.paging.DataSource
import androidx.paging.PositionalDataSource
import happy.mjstudio.paging.core.debugE
import happy.mjstudio.paging.domain.entity.Feed
import happy.mjstudio.paging.domain.repository.FeedRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * Created by mj on 25, November, 2019
 */

class FeedDataSource constructor(
    private val feedRepository : FeedRepository
) : PositionalDataSource<Feed>(), CoroutineScope {

    private val TAG = FeedDataSource::class.java.simpleName

    init {
        debugE(TAG,this)
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Feed>) {
        debugE(TAG,object{}::class.java.enclosingMethod?.name ?: "$TAG : Method Name Not Found")
        launch {
            val items = feedRepository.listFeed(params.loadSize,params.startPosition )
            callback.onResult(items)
        }
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Feed>) {
        val firstLoadPosition = computeInitialLoadPosition(params,100)
        val firstLoadSize = computeInitialLoadSize(params,firstLoadPosition,100)

        debugE(TAG,object{}::class.java.enclosingMethod?.name ?: "$TAG : Method Name Not Found")
        launch {
            val items = feedRepository.listFeed(firstLoadSize,firstLoadPosition)
            callback.onResult(items,0,100)
        }
    }


}
class FeedDataSourceFactory(
    private val feedRepository: FeedRepository
) : DataSource.Factory<Int,Feed>() {

    override fun create(): DataSource<Int, Feed> {
        return FeedDataSource(feedRepository)
    }
}