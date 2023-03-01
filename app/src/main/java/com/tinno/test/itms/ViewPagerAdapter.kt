package com.tinno.test.itms

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val fragmentList: MutableList<Fragment>
) :
    FragmentStateAdapter(fragmentActivity) {

    /**
     * 增加Fragment
     */
    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
    }

    /**
     * 获取Fragment列表
     */
    fun getFragmentList(): List<Fragment> = fragmentList

    override fun getItemCount() = fragmentList.size

    override fun createFragment(position: Int) = fragmentList[position]
}