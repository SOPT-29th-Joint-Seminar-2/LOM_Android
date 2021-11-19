package org.sopt.seminar_2_android.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.seminar_2_android.MainViewPagerAdapter
import org.sopt.seminar_2_android.databinding.ItemBookListBinding
import org.sopt.seminar_2_android.ui.home.BestBookDetailFragment
import org.sopt.seminar_2_android.ui.home.BookData
import org.sopt.seminar_2_android.ui.home.HomeFragment

class BookRecyclerAdapter(var link: HomeFragment.DataToFragment) : RecyclerView.Adapter<BookRecyclerAdapter.BookViewHolder>(){
    private val _bookList = mutableListOf<BookData>()
    private var bookList : List<BookData> = _bookList
    var bookId = 0
    class BookViewHolder(val binding : ItemBookListBinding) : RecyclerView.ViewHolder(binding.root) {
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
        holder.onBind(bookList[position])
        holder.binding.root.setOnClickListener {
            link.getBakeryId(bookId)
        }
    }

    override fun getItemCount(): Int = bookList.size


    fun setBookList(bookList : List<BookData>){
        this.bookList = bookList
        notifyDataSetChanged()
    }
}