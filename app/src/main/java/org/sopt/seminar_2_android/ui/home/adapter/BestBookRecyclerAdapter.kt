package org.sopt.seminar_2_android.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.seminar_2_android.data.model.local.OneReviewData
import org.sopt.seminar_2_android.databinding.ItemBestBookBinding

class BestBookRecyclerAdapter : RecyclerView.Adapter<BestBookRecyclerAdapter.BestBookRecyclerViewHolder>() {
    private val _oneReviewData = mutableListOf<OneReviewData>()
    private var oneReviewData : List<OneReviewData> = _oneReviewData


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BestBookRecyclerViewHolder {
        val binding = ItemBestBookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BestBookRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: BestBookRecyclerAdapter.BestBookRecyclerViewHolder,
        position: Int
    ) {
        holder.onBind(oneReviewData[position])
    }

    override fun getItemCount(): Int {
        return oneReviewData.size
    }

    class BestBookRecyclerViewHolder(
        val binding : ItemBestBookBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun onBind(oneReviewData : OneReviewData){
            binding.apply{
                onereviewdata = oneReviewData
                executePendingBindings()
            }
        }
    }

    fun setReviewData(oneReviewData: List<OneReviewData>){
        this.oneReviewData = oneReviewData
        notifyDataSetChanged()
    }
}