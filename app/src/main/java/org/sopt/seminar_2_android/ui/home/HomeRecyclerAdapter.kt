package org.sopt.seminar_2_android.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.seminar_2_android.databinding.ItemViewBinding


class HomeRecyclerAdapter : RecyclerView.Adapter<HomeRecyclerAdapter.HomePageViewHolder>() {
    val pageList = mutableListOf<HomeData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomePageViewHolder {
        val binding = ItemViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return HomePageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeRecyclerAdapter.HomePageViewHolder, position: Int) {
        holder.onBind(pageList[position])
    }

    override fun getItemCount(): Int = pageList.size

    class HomePageViewHolder(private val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomeData) {
            binding.tvMajorheading.text = data.majorheading
            binding.tvSubheading.text = data.subheading
        }
    }
}