package happy.mjstudio.paging.data.database.dao

import androidx.paging.DataSource
import androidx.room.*
import happy.mjstudio.paging.domain.entity.Feed
import java.util.*

/**
 * Created by mj on 25, November, 2019
 */
@Dao
interface FeedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFeed(vararg feed : Feed)

    @Delete
    suspend fun deleteFeed(vararg feed : Feed) : Int

    @Update
    suspend fun updateFeed(vararg feed : Feed ) : Int

    @Query("SELECT * FROM Feed ORDER BY created DESC LIMIT :limit")
    suspend fun listFeed(limit : Int) : List<Feed>

    @Query("SELECT * FROM Feed WHERE id > :after ORDER BY Created DESC LIMIT :limit")
    suspend fun listFeed(limit : Int, after : Int) : List<Feed>

    @Query("SELECT * FROM Feed ORDER BY Created DESC")
    fun listFeedDataSourceFactory() : DataSource.Factory<Int,Feed>

}