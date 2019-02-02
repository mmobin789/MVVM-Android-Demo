package com.mercari.ui.categories.men

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mercari.R
import com.mercari.base.BaseFragment
import com.mercari.business.MenCategory
import com.mercari.ui.categories.CategoryActivity
import com.mercari.utils.UIAnimationUtils
import kotlinx.android.synthetic.main.fragment_men_category.*

class MenCategoryFragment : BaseFragment<MenCategory>() {

    private lateinit var categoryActivity: CategoryActivity

    companion object {
        fun newInstance() = MenCategoryFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_men_category, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        categoryActivity = activity as CategoryActivity
        tvError.setOnClickListener {
            showLoadingUI(true)
            showErrorUI(false)
            categoryActivity.loadCategory(0)
            //   when {
            // categoryActivity.categoryDataAPIFailed -> categoryActivity.getCategoryData()
            //   categoryActivity.categoriesAPIFailed -> categoryActivity.getCategories()
            //     else ->   categoryActivity.loadCategory(0)
        }

        //   UIAnimationUtils.applyFadeInFadeOut(tvLoading)

        showLoadingUI(true)

        categoryActivity.loadCategory(0)
    }

    private fun showErrorUI(show: Boolean) {
        tvError.visibility = if (show) {
            View.VISIBLE
        } else View.GONE
    }


    private fun showLoadingUI(show: Boolean) {
        tvLoading.visibility = if (show) {
            UIAnimationUtils.applyFadeInFadeOut(tvLoading)
            View.VISIBLE
        } else {
            tvLoading.clearAnimation()
            View.GONE
        }
    }

    override fun onUpdate(t: List<MenCategory>?) {
        val updateSuccess = !t.isNullOrEmpty()
        showLoadingUI(false)

        if (updateSuccess) {
            showErrorUI(false)
        } else { // update the list adapter
            showErrorUI(true)
        }
    }

}