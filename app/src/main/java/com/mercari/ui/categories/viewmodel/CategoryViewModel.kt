package com.mercari.ui.categories.viewmodel

import com.mercari.api.ApiManager
import com.mercari.base.BaseViewModel
import com.mercari.base.di.DaggerStrike
import javax.inject.Inject

class CategoryViewModel : BaseViewModel<CategoryView>() {

    @Inject
    lateinit var apiManager: ApiManager

    init {
        DaggerStrike.doSimpleInjection().here(this)
        getCategoryData()
    }


    private fun getCategoryData() {
        apiManager.getData {
            if (it.isNullOrEmpty())
                getUI().onError()
            else {
                getUI().onCategoryDataReceived(it)

            }
        }
    }


    fun getCategories() {
        apiManager.getCategories {
            if (it != null)
                getUI().onCategoriesReceived(it)
            else getUI().onError()
        }
    }
}