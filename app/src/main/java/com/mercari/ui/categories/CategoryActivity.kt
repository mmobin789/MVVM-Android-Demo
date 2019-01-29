package com.mercari.ui.categories

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.mercari.R
import com.mercari.base.BaseActivity
import com.mercari.ui.categories.adapters.CategoryPagerAdapter
import com.mercari.ui.categories.viewmodel.CategoryViewModel
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : BaseActivity() {

    private lateinit var categoryViewModel: CategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_category)
        super.onCreate(savedInstanceState)

    }

    override fun initViews() {
        categoryViewModel = ViewModelProviders.of(this)[CategoryViewModel::class.java]
        pager.adapter = CategoryPagerAdapter(supportFragmentManager)

    }
}
