package happy.mjstudio.paging.domain.entity

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by mj on 25, November, 2019
 */
@Parcelize
@Entity(tableName = "Feed")
@TypeConverters(CalendarLongConverter::class,IntListJsonConverter::class)
data class Feed(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val created : Calendar,
    val title : String,
    val content : String,
    @ForeignKey(entity = Reply::class,parentColumns = ["id"],childColumns = ["id"])
    val replies : List<Int>,
    val likeCount : Int = 0
) : Parcelable {
    companion object {
        val DIFF = object : DiffUtil.ItemCallback<Feed>() {
            override fun areItemsTheSame(oldItem: Feed, newItem: Feed): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Feed, newItem: Feed): Boolean {
                return oldItem == newItem
            }
        }
    }
}

class CalendarLongConverter {
    @TypeConverter
    fun longToCalendar(src : Long) : Calendar {
        return Calendar.getInstance().apply { timeInMillis = src }
    }

    @TypeConverter
    fun calendarToLong(src : Calendar) : Long {
        return src.timeInMillis
    }
}

class IntListJsonConverter {
    @TypeConverter
    fun listToJson(src : List<Int>) : String {
        val gson = Gson()
        return gson.toJson(src)
    }
    @TypeConverter
    fun jsonToIntList(src : String) : List<Int> {
        val gson = Gson()
        val type = object : TypeToken<List<Int>>(){}.type
        return gson.fromJson(src,type)
    }
}

@Parcelize
@Entity(tableName = "Reply")
data class Reply(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val body : String
) : Parcelable