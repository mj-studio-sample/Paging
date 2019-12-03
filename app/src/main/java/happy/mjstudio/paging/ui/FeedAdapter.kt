package happy.mjstudio.paging.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import happy.mjstudio.paging.core.DateParserUtil
import happy.mjstudio.paging.databinding.ItemFeedBinding
import happy.mjstudio.paging.domain.entity.Feed

/**
 * Created by mj on 25, November, 2019
 */
class FeedAdapter(private val dateParserUtil: DateParserUtil, private val itemClick : (Feed?) -> Unit) : PagedListAdapter<Feed, FeedAdapter.FeedViewHolder>(Feed.DIFF) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = FeedViewHolder(ItemFeedBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) = holder.bind(getItem(position))

    fun submitItems(items : PagedList<Feed>) {
        this.submitList(items)
    }

    inner class FeedViewHolder(private val binding : ItemFeedBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener { itemClick(getItem(layoutPosition)) }
        }

        fun bind(item : Feed?) {
            if(item == null) {
                binding.created.text = ""
                binding.content.text = ""
                binding.likeCount.text = "Loading ..."
            }else {
                binding.likeCount.text = "${item.likeCount} likes"
                binding.created.text = dateParserUtil.parseToYMDHM(item.created)
                binding.item = item

            }
            binding.executePendingBindings()
        }
    }

}

@BindingAdapter("app:adapter_items_Feed")
fun RecyclerView.setFeedAdapterItemBinding(items : PagedList<Feed>?) {
    items ?: return
    (this.adapter as? FeedAdapter)?.submitItems(items)
}