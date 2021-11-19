package org.sopt.seminar_2_android.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import org.sopt.seminar_2_android.MainActivity
import org.sopt.seminar_2_android.MainViewPagerAdapter
import org.sopt.seminar_2_android.R
import org.sopt.seminar_2_android.databinding.FragmentHomeBinding
import org.sopt.seminar_2_android.ui.home.adapter.BookRecyclerAdapter
import org.sopt.seminar_2_android.ui.home.adapter.HomeRecyclerAdapter


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
       bookRecyclerAdapter.setBookList(
           listOf(
               BookData(R.drawable.book4,"1","거꾸로 읽는 세계","유시민" ),
               BookData(R.drawable.book2,"2","달러구트 꿈 백화점 2","이미예(지은이)"),
               BookData(R.drawable.book3,"3","달러구트 꿈 백화점","이미예(지은이)"),
               BookData(R.drawable.book1,"4","오늘밤, 세계에서 이 사랑이\n사라진다해도","이치조 미사키(지은이),권영주\n(옮긴이)"),
               BookData(R.drawable.book5,"5","4~7세 보다 중요한 시기는\n없습니다","이임숙"),
               BookData(R.drawable.book6,"6","다정한 것이 살아남는다","브라이언 헤어·버네사 우즈" )

           )
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