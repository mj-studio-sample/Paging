package happy.mjstudio.paging.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import happy.mjstudio.paging.di.scope.ActivityScope
import happy.mjstudio.paging.ui.MainViewModel

/**
 * Created by mj on 24, November, 2019
 */
@Module
abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ActivityScope
    @ViewModelKey(MainViewModel::class)
    abstract fun provideMainViewModel(viewModel : MainViewModel) : ViewModel
}