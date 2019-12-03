package happy.mjstudio.paging.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    activity : MainActivity,
    private val feedListDataSourceFactoryUseCase: FeedListDataSourceFactoryUseCase,
    private val feedLikeUseCase: FeedLikeUseCase,
    private val feedRepository: FeedRepository
) : ViewModel() {

    companion object {
        private val TAG = MainViewModel::class.java.simpleName
    }

    init {
        debugE(TAG,activity.str)
    }

    private val _feedLikeResult: MutableLiveData<Once<Boolean>> = MutableLiveData()
    val feedLikeResult: LiveData<Once<Boolean>>
        get() = _feedLikeResult

//        val feeds = LivePagedListBuilder(feedListDataSourceFactoryUseCase.execute(Unit),FeedDataSourceFactory.providePagingConfig()).build()
    val feeds = LivePagedListBuilder(FeedDataSourceFactory(feedRepository,viewModelScope), FeedDataSourceFactory.providePagingConfig()).build()

    fun onLike(feed: Feed?) {
        feed ?: return
        viewModelScope.launch {
            kotlin.runCatching { feedLikeUseCase.execute(feed.id) }
                .onSuccess {
                    _feedLikeResult.value = Once(true)
                }.onFailure {
                    debugE(TAG, it)
                    _feedLikeResult.value = Once(false)
                }
        }
    }
}
