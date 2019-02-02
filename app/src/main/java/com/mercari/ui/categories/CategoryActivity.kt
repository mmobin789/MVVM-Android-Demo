package com.mercari.ui.categories

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.mercari.R
import com.mercari.base.BaseActivity
import com.mercari.base.MercariError
import com.mercari.business.Category
import com.mercari.business.CategoryData
import com.mercari.business.MenCategory
import com.mercari.business.WomenCategory
import com.mercari.business.error.AllCategoryError
import com.mercari.business.error.CategoryDataError
import com.mercari.business.error.MenCategoryError
import com.mercari.business.error.WomenCategoryError
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
//    var categoryDataAPIFailed = false
//    var categoriesAPIFailed = false

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
        pager.offscreenPageLimit = 2
        pager.adapter = CategoryPagerAdapter(
                this,
                supportFragmentManager,
                listOf(menCategoryFragment, allCategoryFragment, womenCategoryFragment)
        )
        tabs.setupWithViewPager(pager)

        getCategoryData()

    }

    private fun getCategoryData() {
        categoryViewModel.getCategoryData()
    }

    //  private fun getCategories() = categoryViewModel.getCategories()


    override fun onCategoryDataReceived(categoriesData: List<CategoryData>) {

    }

//    override fun onCategoriesReceived(categories: Categories) {
//        allCategoryFragment.onUpdate(categories.all)
//        menCategoryFragment.onUpdate(categories.men)
//        womenCategoryFragment.onUpdate(categories.women)
//    }


    override fun onError(mercariError: MercariError) {
        when (mercariError) {
            is AllCategoryError -> allCategoryFragment.onUpdate(null)
            is MenCategoryError -> menCategoryFragment.onUpdate(null)
            is WomenCategoryError -> womenCategoryFragment.onUpdate(null)
            is CategoryDataError -> {
                apiFailure()
                //    categoryDataAPIFailed = true
                //  categoriesAPIFailed = false
            }
            else -> // no internet
            {
                apiFailure()
                //  categoryDataAPIFailed = false
                //categoriesAPIFailed = true
            }
        }
    }

    private fun apiFailure() {
        allCategoryFragment.onUpdate(null)
        menCategoryFragment.onUpdate(null)
        womenCategoryFragment.onUpdate(null)
    }

    override fun onAllCategoryReady(category: List<Category>) {
        allCategoryFragment.onUpdate(category)
    }

    override fun onWomenCategoryReady(category: List<WomenCategory>) {
        womenCategoryFragment.onUpdate(category)
    }

    override fun onMenCategoryReady(category: List<MenCategory>) {
        menCategoryFragment.onUpdate(category)
    }

    fun loadCategory(pageNo: Int) {
        when (pageNo) {
            1 -> categoryViewModel.getAllCategory()
            0 -> {
                //  categoriesAPIFailed = false
                //    categoryDataAPIFailed = false
                categoryViewModel.getMenCategory()
            }
            else -> categoryViewModel.getWomenCategory()
        }
    }
}
