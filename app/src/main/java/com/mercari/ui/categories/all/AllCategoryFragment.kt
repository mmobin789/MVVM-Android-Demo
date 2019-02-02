package com.mercari.ui.categories.all

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.mercari.R
import com.mercari.base.BaseFragment
import com.mercari.business.Category
import com.mercari.ui.categories.CategoryActivity
import com.mercari.utils.UIAnimationUtils
import kotlinx.android.synthetic.main.fragment_all_category.*


class AllCategoryFragment : BaseFragment<Category>() {

    private lateinit var categoryActivity: CategoryActivity

    companion object {
        fun newInstance() = AllCategoryFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_all_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rv.layoutManager = GridLayoutManager(context, 2)
        categoryActivity = activity as CategoryActivity

        tvError.setOnClickListener {
            showLoadingUI(true)
            showErrorUI(false)
            categoryActivity.loadCategory(1)
        }


        showLoadingUI(true)

        categoryActivity.loadCategory(1)

    }

    private fun showErrorUI(show: Boolean) {
        tvError.visibility = if (show) {
            View.VISIBLE
        } else {
            View.GONE
        }
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

    override fun onUpdate(t: List<Category>?) {
        val updateSuccess = !t.isNullOrEmpty()
        showLoadingUI(false)

        if (updateSuccess) {
            showErrorUI(false)
        } else { // update the list adapter
            showErrorUI(true)
        }
    }
}