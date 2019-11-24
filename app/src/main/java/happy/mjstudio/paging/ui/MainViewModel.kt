package happy.mjstudio.paging.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.toLiveData
import happy.mjstudio.paging.domain.entity.Feed
import happy.mjstudio.paging.domain.usecase.FeedListDataSourceFactoryUseCase
import javax.inject.Inject

/**
 * Created by mj on 24, November, 2019
 */
class MainViewModel @Inject constructor(
    private val feedListDataSourceFactoryUseCase: FeedListDataSourceFactoryUseCase
)  : ViewModel() {

    companion object {
        private val TAG = MainViewModel::class.java.simpleName
    }

    val feeds : LiveData<PagedList<Feed>> = feedListDataSourceFactoryUseCase.execute(Unit).toLiveData(10)

}
