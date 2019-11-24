package happy.mjstudio.paging.ui

import android.os.Bundle
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import happy.mjstudio.paging.R
import happy.mjstudio.paging.core.debugE
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), HasDefaultViewModelProviderFactory {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory

    override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory {
        return viewModelFactory
    }

    private val mViewModel : MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        debugE(TAG,mViewModel)
    }
}

