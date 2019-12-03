package happy.mjstudio.paging.application

import dagger.android.DaggerApplication
import happy.mjstudio.paging.di.ApplicationComponent
import happy.mjstudio.paging.di.DaggerApplicationComponent
import happy.mjstudio.paging.domain.entity.Feed
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*
import java.util.concurrent.CancellationException

/**
 * Created by mj on 24, November, 2019
 */
class MyApplication : DaggerApplication() {

    companion object {

        lateinit var applicationComponent : ApplicationComponent
        private var createDatasJob : Job? = null

        fun createDatas() {
            createDatasJob = GlobalScope.launch {

                val dao =  applicationComponent.getApplicationDatabase().feedDao()

                (1..100).map {
                    val feed = Feed(created = Calendar.getInstance(),title = "Title $it",content = "Content $it",replies = listOf())
                    dao.insertFeed(feed)
                }

            }

        }
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector() = DaggerApplicationComponent.builder().bindApp(this).build().also { applicationComponent = it }

    override fun onLowMemory() {
        super.onLowMemory()

        createDatasJob?.cancel(CancellationException("Application Quit"))
    }
}