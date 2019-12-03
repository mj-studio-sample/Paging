package happy.mjstudio.paging.domain.datasource

import androidx.paging.ItemKeyedDataSource
import happy.mjstudio.paging.domain.entity.Feed
import happy.mjstudio.paging.domain.repository.FeedRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * Created by mj on 25, November, 2019
 */

fun Timber.e(any : Any?) {
    Timber.e(any.toString())
}

class FeedDataSource constructor(
    private val feedRepository : FeedRepository,
    private val coroutineScope: CoroutineScope
) : ItemKeyedDataSource<Long,Feed>() {

    private val TAG = FeedDataSource::class.java.simpleName

    init {
        Timber.e(this.toString())
    }

    override fun loadInitial(params: LoadInitialParams<Long>, callback: LoadInitialCallback<Feed>) {
        coroutineScope.launch {
            Timber.e("loadIntial ${params.requestedInitialKey} ${params.requestedLoadSize}")
            val items = feedRepository.listFeed(Long.MAX_VALUE)
            callback.onResult(items)
        }
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Feed>) {
        coroutineScope.launch {
            Timber.e("loadAfter ${params.key} ${params.requestedLoadSize}")
            val items = feedRepository.listFeed(params.key)
            callback.onResult(items)
        }
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Feed>) {

    }

    override fun getKey(item: Feed): Long {
        return item.created.timeInMillis
    }
}