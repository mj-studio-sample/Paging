package happy.mjstudio.paging.di.module

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import happy.mjstudio.paging.ui.MainActivity
import happy.mjstudio.paging.ui.MainViewModel

/**
 * Created by mj on 24, November, 2019
 */
@Module
class MainActivityModule {
    @Provides
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun provideMainViewModel(activity : MainActivity) : ViewModel {
        return MainViewModel(activity.age)
    }
}