package org.sopt.seminar_2_android.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
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
                HomeData("으악","ㅋㅋ", R.drawable.book1),
                HomeData("히익","ㅎㅎ", R.drawable.book2)
            )
        )

        homeRecyclerAdapter.notifyDataSetChanged()

    }

}