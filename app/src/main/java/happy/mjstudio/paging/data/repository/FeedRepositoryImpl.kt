package happy.mjstudio.paging.data.repository

import androidx.paging.DataSource
import happy.mjstudio.paging.data.api.FeedAPI
import happy.mjstudio.paging.data.database.dao.FeedDao
import happy.mjstudio.paging.domain.entity.Feed
import happy.mjstudio.paging.domain.repository.FeedRepository
import java.util.*
import javax.inject.Inject

/**
 * Created by mj on 25, November, 2019
 */
class FeedRepositoryImpl @Inject constructor(
    private val dao : FeedDao,
    private val api : FeedAPI
) : FeedRepository {
    override suspend fun insertFeed(vararg feed: Feed) {
        return dao.insertFeed(*feed)
    }

    override suspend fun deleteFeed(vararg feed: Feed): Int {
        return dao.deleteFeed(*feed)
    }

    override suspend fun updateFeed(vararg feed: Feed): Int {
        return dao.updateFeed(*feed)
    }

    override suspend fun listFeed(limit: Int): List<Feed> {
        return dao.listFeed(limit)
    }

    override fun listFeedDataSourceFactory(): DataSource.Factory<Int, Feed> {
        return dao.listFeedDataSourceFactory()
    }
}