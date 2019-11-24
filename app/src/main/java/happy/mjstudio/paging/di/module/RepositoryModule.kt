package happy.mjstudio.paging.di.module

import dagger.Binds
import dagger.Module
import happy.mjstudio.paging.data.repository.FeedRepositoryImpl
import happy.mjstudio.paging.di.scope.ApplicationScope
import happy.mjstudio.paging.domain.repository.FeedRepository

/**
 * Created by mj on 25, November, 2019
 */
@Module
abstract class RepositoryModule {

    @Binds
    @ApplicationScope
    abstract fun bindFeedRepository(repository : FeedRepositoryImpl) : FeedRepository

}