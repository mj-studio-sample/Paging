package happy.mjstudio.paging.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import happy.mjstudio.paging.di.scope.ActivityScope
import happy.mjstudio.paging.ui.MainActivity

/**
 * Created by mj on 24, November, 2019
 */
@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity() : MainActivity

}