package happy.mjstudio.paging.core

import android.util.Log

/**
 * Created by mj on 24, November, 2019
 */
fun debugE(tag: String, message: Any?) {
    if (BuildConfig.DEBUG)
        Log.e(tag, "\uD83C\uDF40" + message.toString())
}