package happy.mjstudio.paging.core

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * Created by mj on 25, November, 2019
 */
class DateParserUtil @Inject constructor() {

    @SuppressLint("SimpleDateFormat")
    private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")

    fun parseToYMD(src : Calendar, separator : String = ".") : String {
        val year = src[Calendar.YEAR]
        val month = src[Calendar.MONTH] + 1
        val date = src[Calendar.DATE]
        return String.format("%04d",year) + separator + String.format("%02d",month) + separator + String.format("%02d",date)
    }
    fun parseToYMDHM(src : Calendar, ymdSeparator: String = ".", timeSeparator : String = ":") : String {
        val ymd = parseToYMD(src,ymdSeparator)
        val hour = src[Calendar.HOUR_OF_DAY]
        val minute = src[Calendar.MINUTE]
        return ymd + " " + String.format("%02d",hour) + timeSeparator + String.format("%02d",minute)
    }

    fun parseString(raw : String) : Calendar {
        val date = simpleDateFormat.parse(raw)

        return Calendar.getInstance().apply { time = date!! }
    }

}