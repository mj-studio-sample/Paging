package happy.mjstudio.paging.domain.usecase

import happy.mjstudio.paging.domain.repository.FeedRepository
import javax.inject.Inject

/**
 * Created by mj on 26, November, 2019
 */
class FeedLikeUseCase @Inject constructor(
    private val feedRepository: FeedRepository
) : CoroutineUseCase<Int,Int> {
    override suspend fun execute(param: Int) : Int {
        return feedRepository.addLike(param)
    }
}