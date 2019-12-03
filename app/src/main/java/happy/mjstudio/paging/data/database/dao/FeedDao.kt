package happy.mjstudio.paging.data.database.dao

import androidx.paging.DataSource
import androidx.room.*
import happy.mjstudio.paging.domain.entity.Feed

/**
 * Created by mj on 25, November, 2019
 */
@Dao
interface FeedDao {

    companion object {
        private val TAG = FeedDao::class.java.simpleName
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFeed(vararg feed : Feed)

    @Delete
    suspend fun deleteFeed(vararg feed : Feed) : Int

    @Update
    suspend fun updateFeed(vararg feed : Feed ) : Int

    @Query("SELECT * FROM Feed WHERE created < :underTime ORDER BY Created DESC LIMIT 10")
    suspend fun listFeed(underTime : Long) : List<Feed>

    @Query("SELECT * FROM Feed ORDER BY Created DESC")
    fun listFeedDataSourceFactory() : DataSource.Factory<Int,Feed>

    @Query("SELECT * FROM Feed WHERE id = :id")
    fun getFeed(id : Int) : Feed

    @Transaction
    suspend fun addLike(id : Int) : Int {
        val feed = getFeed(id)
        val newLikeCount = feed.likeCount + 1
        updateFeed(feed.copy(likeCount = newLikeCount))
        return newLikeCount
    }

}