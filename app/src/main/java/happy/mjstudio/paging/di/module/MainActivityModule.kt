package happy.mjstudio.paging.di.module

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import happy.mjstudio.paging.di.scope.ActivityScope
import happy.mjstudio.paging.ui.MainViewModel

/**
 * Created by mj on 24, November, 2019
 */
@Module
class MainActivityModule {
    @Provides
    @IntoMap
    @ActivityScope
    @ViewModelKey(MainViewModel::class)
    fun provideMainViewModel() : ViewModel {
        return MainViewModel()
    }
}