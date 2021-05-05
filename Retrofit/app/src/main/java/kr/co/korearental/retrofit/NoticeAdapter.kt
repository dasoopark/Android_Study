package kr.co.korearental.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.korearental.retrofit.databinding.ItemNoticeBinding

class NoticeAdapter : RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {
    private var items = ArrayList<Content>()

    //binding 받기 위해 item_notice => ItemNoticeBinding 표현식으로 바꿔서 상속
    inner class NoticeViewHolder(private val binding: ItemNoticeBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(notice: Content){

            binding.tvTitle.text = notice.title
            binding.tvDate.text = notice.date.substring(0, 10)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : NoticeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemNoticeBinding.inflate(layoutInflater, parent, false)
        return NoticeViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setList(notice: ArrayList<Content>) {
        items = notice
    }
}