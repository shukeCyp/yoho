package com.example.yoho.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * @Author:YaPeng
 * @Date:2021/8/2
 * @Email:3536815334@qq.com
 */
class FragmentStateAdapter(
    fm: FragmentManager,
    behavior: Int,
    private val fragments: List<Fragment>
) : FragmentStatePagerAdapter(fm, behavior) {
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}