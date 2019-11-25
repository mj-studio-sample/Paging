package happy.mjstudio.paging.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import happy.mjstudio.paging.application.MyApplication
import happy.mjstudio.paging.data.database.ApplicationDatabase
import happy.mjstudio.paging.data.database.MIGRATION_1_TO_2
import happy.mjstudio.paging.data.database.dao.FeedDao
import happy.mjstudio.paging.di.scope.ApplicationScope

/**
 * Created by mj on 25, November, 2019
 */
@Module
class DatabaseModule {
    @Provides
    @ApplicationScope
    fun provideApplicationDatabase(context : Context) : ApplicationDatabase {
        return Room.databaseBuilder(context,ApplicationDatabase::class.java,"ApplicationDatabase-2")
            .addMigrations(MIGRATION_1_TO_2)
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    MyApplication.createDatas()
                }
            })
            .build()
    }

    @Provides
    @ApplicationScope
    fun provideFeedDao(database : ApplicationDatabase) : FeedDao = database.feedDao()
}