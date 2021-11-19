package org.sopt.seminar_2_android.ui.home

import android.os.Bundle
import android.view.View
import org.sopt.seminar_2_android.R
import org.sopt.seminar_2_android.data.model.local.OneReviewData
import org.sopt.seminar_2_android.databinding.FragmentBestBookBinding
import org.sopt.seminar_2_android.databinding.FragmentBestBookDetailBinding
import org.sopt.seminar_2_android.ui.base.BaseFragment
import org.sopt.seminar_2_android.ui.home.adapter.BestBookRecyclerAdapter


class BestBookDetailFragment : BaseFragment<FragmentBestBookDetailBinding>(R.layout.fragment_best_book_detail) {
    private lateinit var bestBookRecyclerAdapter: BestBookRecyclerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBestBook()
    }



    private fun initBestBook(){
        val oneReviewData = mutableListOf(
            OneReviewData(
                R.drawable.ic_profile_gray,
                "아요짱",
                "2021.11.05",
                "책보면서 먹는 사과가 젤 맛있쪙!"
            ),
            OneReviewData(
                R.drawable.ic_profile_gray,
                "안드킹",
                "2021.11.05",
                "페니가 성장한 만큼,저도 성장했습니다!"
            )
        )

        bestBookRecyclerAdapter = BestBookRecyclerAdapter()
        binding.rcBestBook.adapter = bestBookRecyclerAdapter
        bestBookRecyclerAdapter.setReviewData(oneReviewData)
    }
}