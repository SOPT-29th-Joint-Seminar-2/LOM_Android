package org.sopt.seminar_2_android.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.seminar_2_android.R
import org.sopt.seminar_2_android.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var homeRecyclerAdapter: HomeRecyclerAdapter
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        initAdapter()

        return binding.root
    }

    private fun initAdapter() {
        homeRecyclerAdapter = HomeRecyclerAdapter()

        binding.vpHome.adapter = homeRecyclerAdapter

        homeRecyclerAdapter.pageList.addAll(
            listOf(
                HomeData("SNS로 '진짜 나'를\n찾을 수 있을까 ","종이책 출간 전에 읽는 화제의 신작", R.drawable.img_banner_1),
                HomeData("11주 연속 베스트 셀러\n김영하 북클럽 선정도서","11월 8일 커밍 순!", R.drawable.img_banner_2),
              //  HomeData("영화와 책을 아우르는\n씨네21 칼럼니스트","이다혜 작가전 보러가기!",R.drawable.img_banner_3)
            )
        )

        homeRecyclerAdapter.notifyDataSetChanged()

    }



}