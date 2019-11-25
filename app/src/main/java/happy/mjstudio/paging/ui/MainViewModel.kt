package happy.mjstudio.paging.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Config
import androidx.paging.LivePagedListBuilder
import happy.mjstudio.paging.core.Once
import happy.mjstudio.paging.core.debugE
import happy.mjstudio.paging.domain.datasource.FeedDataSourceFactory
import happy.mjstudio.paging.domain.entity.Feed
import happy.mjstudio.paging.domain.repository.FeedRepository
import happy.mjstudio.paging.domain.usecase.FeedLikeUseCase
import happy.mjstudio.paging.domain.usecase.FeedListDataSourceFactoryUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by mj on 24, November, 2019
 */
class MainViewModel @Inject constructor(
    private val feedListDataSourceFactoryUseCase: FeedListDataSourceFactoryUseCase,
    private val feedLikeUseCase : FeedLikeUseCase,
    private val feedRepository: FeedRepository
) : ViewModel() {

    companion object {
        private val TAG = MainViewModel::class.java.simpleName
    }

    private val config = Config(
        10,
        0,
        true,
        10,
        1000
    )

    private val _feedLikeResult : MutableLiveData<Once<Boolean>> = MutableLiveData()
    val feedLikeResult : LiveData<Once<Boolean>>
        get() = _feedLikeResult

//    val feeds = LivePagedListBuilder(feedListDataSourceFactoryUseCase.execute(Unit),config).build()
    val feeds = LivePagedListBuilder(FeedDataSourceFactory(feedRepository),config).build()

    fun onLike(feed : Feed?) {
        feed ?: return
        viewModelScope.launch {
            kotlin.runCatching { feedLikeUseCase.execute(feed.id)}
                .onSuccess {
                    feeds.value?.dataSource?.invalidate()
                    debugE(TAG,"success")
                }.onFailure {
                    debugE(TAG,it)
                    _feedLikeResult.value = Once(false)
                }
        }
    }
}
