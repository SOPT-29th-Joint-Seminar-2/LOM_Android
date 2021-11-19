package org.sopt.seminar_2_android.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.seminar_2_android.R
import org.sopt.seminar_2_android.databinding.FragmentBestBookBinding


class BestBookFragment : Fragment() {
    private lateinit var bookRecyclerAdapter : BookRecyclerAdapter
    private lateinit var binding: FragmentBestBookBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBestBookBinding.inflate(layoutInflater)
        bookRecyclerAdapter = BookRecyclerAdapter()
        binding.rvBooklist.adapter = bookRecyclerAdapter
        bookRecyclerAdapter.BookList.addAll(
            listOf<BookData>(
                BookData(R.drawable.book4,"1","거꾸로 읽는 세계","유시민" ),
                BookData(R.drawable.book2,"2","달러구트 꿈 백화점 2","이미예(지은이)"),
                BookData(R.drawable.book3,"3","달러구트 꿈 백화점","이미예(지은이)"),
                BookData(R.drawable.book1,"4","오늘밤, 세계에서 이 사랑이\n사라진다해도","이치조 미사키(지은이),권영주\n(옮긴이)"),
                BookData(R.drawable.book5,"5","4~7세 보다 중요한 시기는\n없습니다","이임숙"),
                BookData(R.drawable.book6,"6","다정한 것이 살아남는다","브라이언 헤어·버네사 우즈" )

                )
        )

        bookRecyclerAdapter.notifyDataSetChanged()
        // Inflate the layout for this fragment
        return binding.root
    }

}