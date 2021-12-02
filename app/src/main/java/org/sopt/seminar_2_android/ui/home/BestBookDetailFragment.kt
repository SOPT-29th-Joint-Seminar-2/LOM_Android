package org.sopt.seminar_2_android.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import org.sopt.seminar_2_android.R
import org.sopt.seminar_2_android.data.model.local.OneReviewData
import org.sopt.seminar_2_android.databinding.FragmentBestBookBinding
import org.sopt.seminar_2_android.databinding.FragmentBestBookDetailBinding
import org.sopt.seminar_2_android.ui.base.BaseFragment
import org.sopt.seminar_2_android.ui.home.adapter.BestBookRecyclerAdapter
import org.sopt.seminar_2_android.ui.home.viewmodel.HomeViewModel


class BestBookDetailFragment : BaseFragment<FragmentBestBookDetailBinding>(R.layout.fragment_best_book_detail) {
    private val homeViewModel : HomeViewModel by viewModels()
    private lateinit var bestBookRecyclerAdapter: BestBookRecyclerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBestBook()
        writeReview()
    }



    private fun initBestBook(){
        homeViewModel.getBookDetail(1)
        homeViewModel.bookInfoList.observe(viewLifecycleOwner){
            binding.bookDetailInfoList = it
        }


       bestBookRecyclerAdapter = BestBookRecyclerAdapter()
        binding.rcBestBook.adapter = bestBookRecyclerAdapter
        homeViewModel.reviewList.observe(viewLifecycleOwner){
            bestBookRecyclerAdapter.setReviewData(it)

        }
        bestBookRecyclerAdapter.setItemClickListener(object : BestBookRecyclerAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                homeViewModel.putLikeCount(bestBookRecyclerAdapter.oneReviewData[position].id)
                homeViewModel.getBookDetail(1)
            }
        })
    }

    private fun writeReview(){
        binding.textOneReivewRegister.setOnClickListener {
            val text = binding.etOneReviewChat.text.toString()
            homeViewModel.postReviewWrite(text)
            homeViewModel.getBookDetail(1)
        }

    }

}