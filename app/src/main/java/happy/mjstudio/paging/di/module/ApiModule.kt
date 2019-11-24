package happy.mjstudio.paging.di.module

import dagger.Module
import dagger.Provides
import happy.mjstudio.paging.data.api.FeedAPI
import happy.mjstudio.paging.di.scope.ApplicationScope

/**
 * Created by mj on 25, November, 2019
 */
@Module
class ApiModule {
    @Provides
    @ApplicationScope
    fun provideFeedAPI() : FeedAPI {
        return FeedAPI()
    }
}