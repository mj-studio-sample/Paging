package happy.mjstudio.paging.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import happy.mjstudio.paging.data.database.dao.FeedDao
import happy.mjstudio.paging.domain.entity.Feed
import happy.mjstudio.paging.domain.entity.Reply

/**
 * Created by mj on 25, November, 2019
 */
@Database(entities = [Feed::class, Reply::class],version = 2,exportSchema = true)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun feedDao() : FeedDao
}

val MIGRATION_1_TO_2 = object : Migration(1,2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE Feed Add `likeCount` INTEGER DEFAULT 0 NOT NULL")
    }
}