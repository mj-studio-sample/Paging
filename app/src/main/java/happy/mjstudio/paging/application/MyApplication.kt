package happy.mjstudio.paging.application

import dagger.android.DaggerApplication
import happy.mjstudio.paging.di.DaggerApplicationComponent

/**
 * Created by mj on 24, November, 2019
 */
class MyApplication : DaggerApplication() {
    override fun applicationInjector() = DaggerApplicationComponent.builder().bindApp(this).build()
}