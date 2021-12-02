package org.sopt.seminar_2_android.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.seminar_2_android.MainViewPagerAdapter
import org.sopt.seminar_2_android.databinding.ItemBookListBinding
import org.sopt.seminar_2_android.ui.home.BestBookDetailFragment
import org.sopt.seminar_2_android.ui.home.BookData
import org.sopt.seminar_2_android.ui.home.HomeFragment
import org.sopt.seminar_2_android.ui.home.ResponseLOMData

class BookRecyclerAdapter(var link: HomeFragment.DataToFragment) : RecyclerView.Adapter<BookRecyclerAdapter.BookViewHolder>(){
    private val _bookList = mutableListOf<ResponseLOMData.Data>()
    private var bookList : List<ResponseLOMData.Data> = _bookList
    var bookId = 0
    class BookViewHolder(val binding : ItemBookListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : ResponseLOMData.Data){

            binding.tvRank.text = data.bookId.toString()
            binding.tvTitle.text = data.bookName
            binding.tvWriter.text = data.author

            Glide.with(binding.ivBestbook)
                .load(data.bookImg)
                .into(binding.ivBestbook)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookListBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.onBind(bookList[position])
        holder.binding.root.setOnClickListener {
            link.getBakeryId(bookId)
        }
    }

    override fun getItemCount(): Int = bookList.size


    fun setBookList(bookList : List<ResponseLOMData.Data>){
        this.bookList = bookList
        notifyDataSetChanged()
    }
}