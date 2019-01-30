package com.mercari.ui.categories

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.mercari.R
import com.mercari.base.BaseActivity
import com.mercari.business.Categories
import com.mercari.business.CategoryData
import com.mercari.ui.categories.adapters.CategoryPagerAdapter
import com.mercari.ui.categories.all.AllCategoryFragment
import com.mercari.ui.categories.men.MenCategoryFragment
import com.mercari.ui.categories.viewmodel.CategoryView
import com.mercari.ui.categories.viewmodel.CategoryViewModel
import com.mercari.ui.categories.women.WomenCategoryFragment
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : BaseActivity(), CategoryView {

    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var allCategoryFragment: AllCategoryFragment
    private lateinit var menCategoryFragment: MenCategoryFragment
    private lateinit var womenCategoryFragment: WomenCategoryFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_category)
        super.onCreate(savedInstanceState)

    }

    override fun initViews() {
        allCategoryFragment = AllCategoryFragment.newInstance()
        menCategoryFragment = MenCategoryFragment.newInstance()
        womenCategoryFragment = WomenCategoryFragment.newInstance()
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)
        categoryViewModel.attachUI(this)
        pager.adapter = CategoryPagerAdapter(
            this,
            supportFragmentManager,
            listOf(menCategoryFragment, allCategoryFragment, womenCategoryFragment)
        )
        tabs.setupWithViewPager(pager)


    }

    override fun onCategoryDataReceived(categoriesData: List<CategoryData>) {
        Toast.makeText(this, "Success 1", Toast.LENGTH_SHORT).show()
        categoryViewModel.getCategories()

    }

    override fun onCategoriesReceived(categories: Categories) {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
    }


    override fun onError() {
        Toast.makeText(this, "Oops An Error!", Toast.LENGTH_SHORT).show()
    }
}
