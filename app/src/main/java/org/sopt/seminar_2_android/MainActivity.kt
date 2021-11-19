package org.sopt.seminar_2_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import org.sopt.seminar_2_android.databinding.ActivityMainBinding
import org.sopt.seminar_2_android.ui.FeedFragment
import org.sopt.seminar_2_android.ui.base.BaseActivity
import org.sopt.seminar_2_android.ui.home.HomeFragment
import org.sopt.seminar_2_android.ui.mylibrary.MyLibraryFragment

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private lateinit var mainViewPagerAdapter: MainViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewPager()
        iniBottomNavigation()
    }

    private fun initViewPager(){
        val fragmentList = listOf(HomeFragment(), FeedFragment(), MyLibraryFragment())

        mainViewPagerAdapter = MainViewPagerAdapter(this)
        mainViewPagerAdapter.fragments.addAll(fragmentList)
        binding.vpMain.adapter = mainViewPagerAdapter
        binding.vpMain.isUserInputEnabled = false
    }


    private fun iniBottomNavigation(){
        with(binding){
            vpMain.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    bnvMain.menu.getItem(position).isChecked = true
                }
            })

            bnvMain.setOnItemSelectedListener {
                when(it.itemId){
                    R.id.item_home -> {
                        vpMain.currentItem = HOME_FRAGMENT
                        return@setOnItemSelectedListener true
                    }
                    R.id.item_feed -> {
                        vpMain.currentItem = FEED_FRAGMENT
                        return@setOnItemSelectedListener true
                    }

                    else -> {
                        vpMain.currentItem = LIBRARY_FRAGMENT
                        return@setOnItemSelectedListener true
                    }
                }
            }
        }
    }

    companion object{
        const val HOME_FRAGMENT = 0
        const val FEED_FRAGMENT = 1
        const val LIBRARY_FRAGMENT = 2
    }
}