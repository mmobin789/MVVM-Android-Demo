package com.mercari.ui.categories.adapters

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mercari.base.BaseFragment
import com.mercari.ui.categories.all.AllCategoryFragment
import com.mercari.ui.categories.men.MenCategoryFragment
import com.mercari.ui.categories.women.WomenCategoryFragment

class CategoryPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): BaseFragment {

        return when (position) {
            1 -> {
                AllCategoryFragment.newInstance()
            }
            2 -> {
                WomenCategoryFragment.newInstance()
            }
            else -> {
                MenCategoryFragment.newInstance()

            }
        }

    }

    override fun getCount(): Int {
        return 3
    }

}