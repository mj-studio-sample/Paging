package happy.mjstudio.paging.domain.repository

import androidx.paging.DataSource
import happy.mjstudio.paging.domain.entity.Feed
import java.util.*

/**
 * Created by mj on 25, November, 2019
 */
interface FeedRepository {
    suspend fun insertFeed(vararg feed : Feed)
    suspend fun deleteFeed(vararg feed : Feed) : Int
    suspend fun updateFeed(vararg feed : Feed) : Int
    suspend fun listFeed(limit : Int = 10) : List<Feed>
    fun listFeedDataSourceFactory() : DataSource.Factory<Int,Feed>
}