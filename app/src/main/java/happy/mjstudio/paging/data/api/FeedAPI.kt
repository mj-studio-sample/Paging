package happy.mjstudio.paging.data.api

import happy.mjstudio.paging.domain.entity.Feed
import java.util.*
import kotlin.random.Random

/**
 * Created by mj on 25, November, 2019
 */
class FeedAPI {
    
    companion object {
        fun generateDummyFeed() : Feed {

            val id = Random.nextInt()

            return Feed(id, Calendar.getInstance(),"Title $id","Content $id",listOf())

         }
    }

    suspend fun listFeed(limit : Int) : List<Feed> {
        return (1..30).map { generateDummyFeed() }
    }

}