package happy.mjstudio.paging.domain.repository

import androidx.paging.DataSource
import happy.mjstudio.paging.domain.entity.Feed

/**
 * Created by mj on 25, November, 2019
 */
interface FeedRepository {
    suspend fun insertFeed(vararg feed : Feed)
    suspend fun deleteFeed(vararg feed : Feed) : Int
    suspend fun updateFeed(vararg feed : Feed) : Int
    suspend fun listFeed(limit : Int = 10,offset : Int = 0) : List<Feed>
    suspend fun addLike(id : Int) : Int
    fun listFeedDataSourceFactory() : DataSource.Factory<Int,Feed>
}