package happy.mjstudio.paging.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import happy.mjstudio.paging.application.MyApplication
import happy.mjstudio.paging.data.database.ApplicationDatabase
import happy.mjstudio.paging.di.module.ActivityModule
import happy.mjstudio.paging.di.module.DatabaseModule
import happy.mjstudio.paging.di.module.RepositoryModule
import happy.mjstudio.paging.di.module.ViewModelModule
import happy.mjstudio.paging.di.scope.ApplicationScope

/**
 * Created by mj on 24, November, 2019
 */
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        DatabaseModule::class,
        RepositoryModule::class
    ])
@ApplicationScope
interface ApplicationComponent : AndroidInjector<MyApplication> {
    override fun inject(instance: MyApplication?)

    @Component.Builder
    interface Builder {
        fun build() : ApplicationComponent
        @BindsInstance
        fun bindApp(app : Application) : Builder
    }

    fun getApplicationDatabase() : ApplicationDatabase
}