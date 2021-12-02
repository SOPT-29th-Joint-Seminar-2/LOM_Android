package org.sopt.seminar_2_android.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import org.sopt.seminar_2_android.MainActivity
import org.sopt.seminar_2_android.MainViewPagerAdapter
import org.sopt.seminar_2_android.R
import org.sopt.seminar_2_android.databinding.FragmentHomeBinding
import org.sopt.seminar_2_android.ui.home.adapter.BookRecyclerAdapter
import org.sopt.seminar_2_android.ui.home.adapter.HomeRecyclerAdapter
import org.sopt.seminar_2_android.util.enqueueUtil


class HomeFragment : Fragment() {
    private lateinit var homeRecyclerAdapter: HomeRecyclerAdapter
    private lateinit var binding: FragmentHomeBinding
    private lateinit var bookRecyclerAdapter : BookRecyclerAdapter
    private lateinit var mainViewPagerAdapter: MainViewPagerAdapter
    var link = DataToFragment()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initBestBookRecycler()
        initNetwork()
    }

    private fun initAdapter() {
        homeRecyclerAdapter = HomeRecyclerAdapter()

        binding.vpHome.adapter = homeRecyclerAdapter

        homeRecyclerAdapter.pageList.addAll(
            listOf(
                HomeData(R.drawable.ic_btn_1,"SNS로 '진짜 나'를\n찾을 수 있을까 ","종이책 출간 전에 읽는 화제의 신작", R.drawable.img_banner_1),
                HomeData(R.drawable.ic_btn_2,"11주 연속 베스트 셀러\n김영하 북클럽 선정도서","11월 8일 커밍 순!", R.drawable.img_banner_2),
                HomeData(R.drawable.ic_btn_3,"영화와 책을 아우르는\n씨네21 칼럼니스트","이다혜 작가전 보러가기!",R.drawable.img_banner_3)
            )
        )

        homeRecyclerAdapter.notifyDataSetChanged()

    }

   private fun initBestBookRecycler(){
       bookRecyclerAdapter = BookRecyclerAdapter(link)
       binding.rcHomeBestBook.adapter = bookRecyclerAdapter

   }

    private fun initNetwork(){

        val call = ServiceCreator.apiService.getInfo()

        call.enqueueUtil(
            onSuccess = {
                bookRecyclerAdapter.setBookList(
                    it.data
                )
            }
        )
    }

    inner class DataToFragment {
        fun getBakeryId(bookId: Int) {
            if (bookId == 0) {
              val mainActivity = activity as MainActivity
                mainActivity.receiveData(0)
            }
        }
    }
}