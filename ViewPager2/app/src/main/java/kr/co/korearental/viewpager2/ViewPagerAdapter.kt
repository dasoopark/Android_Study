package kr.co.korearental.viewpager2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.idol_list_item.view.*
                    //ArrayList<Int> 부분 뭐넣을지에 따라 다름 이떄 img= int로 저장되기 때문에 이걸로한거고
                    //텍스트를 화면에 표시하고 싶을땐 String으로 담아야함.
class ViewPagerAdapter(idolList: ArrayList<Int>) : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
    var item = idolList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.idol.setImageResource(item[position])
    }

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.idol_list_item, parent, false)){
        val idol = itemView.imageView_idol!!
    }
}