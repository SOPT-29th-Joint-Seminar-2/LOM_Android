package org.sopt.seminar_2_android.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.seminar_2_android.databinding.ItemBookListBinding

class BookRecyclerAdapter : RecyclerView.Adapter<BookRecyclerAdapter.BookViewHolder>(){
    val BookList = mutableListOf<BookData>()

    class BookViewHolder(private val binding : ItemBookListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : BookData){
            binding.ivBestbook.setImageResource(data.book_img)
            binding.tvRank.text = data.rank
            binding.tvTitle.text = data.title
            binding.tvWriter.text = data.writer

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookListBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.onBind(BookList[position])
    }

    override fun getItemCount(): Int = BookList.size

}