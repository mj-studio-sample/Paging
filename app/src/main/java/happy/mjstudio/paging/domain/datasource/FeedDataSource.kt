package happy.mjstudio.paging.domain.datasource

import androidx.paging.ItemKeyedDataSource
import happy.mjstudio.paging.domain.entity.Feed
import happy.mjstudio.paging.domain.repository.FeedRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by mj on 25, November, 2019
 */
class FeedDataSource @Inject constructor(
    private val feedRepository : FeedRepository
) : ItemKeyedDataSource<Int,Feed>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Feed>) {
        GlobalScope.launch {
            val feeds = feedRepository.listFeed(params.requestedLoadSize)
            callback.onResult(feeds)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Feed>) {
        GlobalScope.launch {
            val feeds = feedRepository.listFeed()

        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Feed>) {
    }

    override fun getKey(item: Feed): Int {
        return item.id
    }
}