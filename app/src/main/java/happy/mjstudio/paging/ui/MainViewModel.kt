package happy.mjstudio.paging.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import happy.mjstudio.paging.core.debugE
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by mj on 24, November, 2019
 */
class MainViewModel @Inject constructor(
    private val age : Int
) : ViewModel() {

    companion object {
        private val TAG = MainViewModel::class.java.simpleName
    }

    init {
        viewModelScope.launch {
            delay(1000)
            debugE(TAG,age)
        }
    }
}
