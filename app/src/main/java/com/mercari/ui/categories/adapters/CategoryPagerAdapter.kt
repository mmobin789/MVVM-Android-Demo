package com.mercari.ui.categories.adapters

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mercari.R
import com.mercari.base.BaseFragment

class CategoryPagerAdapter(
    context: Context,
    fragmentManager: FragmentManager,
    private val list: List<BaseFragment>
) : FragmentPagerAdapter(fragmentManager) {

    private val names =
        listOf(context.getString(R.string.men), context.getString(R.string.all), context.getString(R.string.women))


    override fun getItem(position: Int): BaseFragment {
        return list[position]

    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return names[position]
    }

}