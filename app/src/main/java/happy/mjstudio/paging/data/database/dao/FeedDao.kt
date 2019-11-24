package happy.mjstudio.paging.data.database.dao

import androidx.room.*
import happy.mjstudio.paging.domain.entity.Feed

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

}