package happy.mjstudio.paging.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by mj on 24, November, 2019
 */
class MainViewModel : ViewModel() {

    companion object {
        private val TAG = MainViewModel::class.java.simpleName
    }

    init {
        viewModelScope.launch {
            delay(1000)
        }
    }
}
