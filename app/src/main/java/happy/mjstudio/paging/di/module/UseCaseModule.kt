package happy.mjstudio.paging.di.module

import dagger.Module
import dagger.Provides
import happy.mjstudio.paging.di.scope.ApplicationScope
import happy.mjstudio.paging.domain.repository.FeedRepository
import happy.mjstudio.paging.domain.usecase.FeedLikeUseCase
import happy.mjstudio.paging.domain.usecase.FeedListDataSourceFactoryUseCase
import happy.mjstudio.paging.domain.usecase.FeedListUseCase

/**
 * Created by mj on 25, November, 2019
 */
@Module
class UseCaseModule {
    @Provides
    @ApplicationScope
    fun feedListUseCase(feedRepository: FeedRepository) : FeedListUseCase {
        return FeedListUseCase(feedRepository)
    }

    @Provides
    @ApplicationScope
    fun feedListDataSourceFactoryUseCase(feedRepository: FeedRepository) : FeedListDataSourceFactoryUseCase {
        return FeedListDataSourceFactoryUseCase(feedRepository)
    }

    @Provides
    @ApplicationScope
    fun feedAddLikeUseCase(feedRepository: FeedRepository) = FeedLikeUseCase(feedRepository)
}