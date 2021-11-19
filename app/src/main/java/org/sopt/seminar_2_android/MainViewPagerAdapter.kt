package org.sopt.seminar_2_android

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainViewPagerAdapter(fragmentActivity: FragmentActivity):
    FragmentStateAdapter(fragmentActivity){
        val fragments = mutableListOf<Fragment>()
    val fragmentIds = fragments.map { it.hashCode().toLong() }
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    override fun getItemId(position: Int): Long {
        return fragments[position].hashCode().toLong()
    }

    override fun containsItem(itemId: Long): Boolean {
        return fragmentIds.contains(itemId)
    }

    fun changeFragment(num : Int, fragment: Fragment) {
        this.fragments[num] = fragment
        notifyItemChanged(num+1)

    }
}

