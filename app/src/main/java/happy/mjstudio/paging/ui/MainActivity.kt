package happy.mjstudio.paging.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import happy.mjstudio.paging.core.DateParserUtil
import happy.mjstudio.paging.core.observeOnce
import happy.mjstudio.paging.databinding.ActivityMainBinding
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity(), HasDefaultViewModelProviderFactory {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private lateinit var mBinding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory

    @Inject
    lateinit var dateParserUtil: DateParserUtil


    override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory {
        return viewModelFactory
    }

    private val mViewModel : MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        mBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        mBinding.lifecycleOwner = this
        mBinding.vm = mViewModel
        setContentView(mBinding.root)

        initView()
        observeViewModel()
    }

    private fun initView() {
        mBinding.recyclerView.apply {
            adapter = FeedAdapter(dateParserUtil) {
                mViewModel.onLike(it)
            }
        }
    }

    private fun observeViewModel() {
        mViewModel.apply {
            feedLikeResult.observeOnce(this@MainActivity) {
                (mBinding.recyclerView.adapter as? FeedAdapter)?.currentList?.dataSource?.invalidate()
            }
        }
    }
}

