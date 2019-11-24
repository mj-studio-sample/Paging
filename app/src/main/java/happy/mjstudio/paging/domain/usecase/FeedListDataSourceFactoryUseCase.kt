package happy.mjstudio.paging.domain.usecase

import androidx.paging.DataSource
import happy.mjstudio.paging.domain.entity.Feed
import happy.mjstudio.paging.domain.repository.FeedRepository
import javax.inject.Inject

/**
 * Created by mj on 25, November, 2019
 */
class FeedListDataSourceFactoryUseCase @Inject constructor(private val feedRepository: FeedRepository) : UseCase<DataSource.Factory<Int,Feed>, Unit> {
    override fun execute(param: Unit): DataSource.Factory<Int,Feed> {
        return feedRepository.listFeedDataSourceFactory()
    }
}