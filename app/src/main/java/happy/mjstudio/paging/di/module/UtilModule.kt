package happy.mjstudio.paging.di.module

import dagger.Module
import dagger.Provides
import happy.mjstudio.paging.core.DateParserUtil
import happy.mjstudio.paging.di.scope.ApplicationScope

/**
 * Created by mj on 25, November, 2019
 */
@Module
class UtilModule {
    @Provides
    @ApplicationScope
    fun provideDateParserUtil() = DateParserUtil()
}