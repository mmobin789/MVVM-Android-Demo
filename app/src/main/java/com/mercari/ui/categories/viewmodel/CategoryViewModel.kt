package com.mercari.ui.categories.viewmodel

import com.mercari.api.ApiManager
import com.mercari.base.BaseViewModel
import com.mercari.base.di.DaggerStrike
import com.mercari.business.error.AllCategoryError
import com.mercari.business.error.CategoryDataError
import com.mercari.business.error.MenCategoryError
import com.mercari.business.error.WomenCategoryError
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CategoryViewModel : BaseViewModel<CategoryView>() {

    @Inject
    lateinit var apiManager: ApiManager

    private val compositeDisposable = CompositeDisposable()


    init {
        DaggerStrike.doSimpleInjection().here(this)

    }


    fun getCategoryData() {
        compositeDisposable.add(apiManager.getData {
            if (it.isNullOrEmpty())
                getUI().onError(CategoryDataError(""))
            else {
                getUI().onCategoryDataReceived(it)

            }
        })
    }

// below RX implementation can be used for combined network requests which allow to fetch data from network concurrently.
//    fun getCategories() {
//        compositeDisposable.add(apiManager.getCategories {
//            if (it != null)
//                getUI().onCategoriesReceived(it)
//            else getUI().onError(CategoriesError(""))
//        })
//    }

    fun getWomenCategory() {
        compositeDisposable.add(apiManager.getWomenCategory {
            if (it != null)
                getUI().onWomenCategoryReady(it)
            else getUI().onError(WomenCategoryError(""))
        })
    }

    fun getMenCategory() {
        compositeDisposable.add(apiManager.getMenCategory {
            if (it != null)
                getUI().onMenCategoryReady(it)
            else getUI().onError(MenCategoryError(""))
        })
    }

    fun getAllCategory() {
        compositeDisposable.add(apiManager.getAllCategory {
            if (it != null)
                getUI().onAllCategoryReady(it)
            else getUI().onError(AllCategoryError(""))
        })
    }


    override fun onCleared() {
        compositeDisposable.clear()
    }
}