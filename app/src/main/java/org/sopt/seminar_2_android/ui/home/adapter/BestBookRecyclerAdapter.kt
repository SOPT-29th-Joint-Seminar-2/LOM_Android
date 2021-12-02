package org.sopt.seminar_2_android.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.seminar_2_android.data.model.local.OneReviewData
import org.sopt.seminar_2_android.data.model.remote.response.ResponseBookDetail
import org.sopt.seminar_2_android.databinding.ItemBestBookBinding
import org.sopt.seminar_2_android.ui.home.BestBookDetailFragment

class BestBookRecyclerAdapter : RecyclerView.Adapter<BestBookRecyclerAdapter.BestBookRecyclerViewHolder>() {
    private val _oneReviewData = mutableListOf<ResponseBookDetail.Data.Review>()
     var oneReviewData : List<ResponseBookDetail.Data.Review> = _oneReviewData


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

        holder.binding.imgBestBookReviewLikeCount.setOnClickListener {
            itemClickListener.onClick(it, position)

        }
    }

    override fun getItemCount(): Int {
        return oneReviewData.size
    }

    class BestBookRecyclerViewHolder(
        val binding : ItemBestBookBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun onBind(oneReviewData : ResponseBookDetail.Data.Review){
            binding.apply{
                onereviewdata = oneReviewData
                executePendingBindings()
            }
        }
    }

    fun setReviewData(oneReviewData: List<ResponseBookDetail.Data.Review>){
        this.oneReviewData = oneReviewData
        notifyDataSetChanged()
    }

    interface OnItemClickListener{
        fun onClick(v: View, position : Int)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener){
        this.itemClickListener = onItemClickListener
    }

    private lateinit var itemClickListener : OnItemClickListener
}