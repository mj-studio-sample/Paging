package happy.mjstudio.paging.domain.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by mj on 25, November, 2019
 */
@Parcelize
@Entity(tableName = "Feed")
data class Feed(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val created : Calendar,
    val title : String,
    val content : String,
    val replies : List<Reply>
) : Parcelable


@Parcelize
data class Reply(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val body : String
) : Parcelable