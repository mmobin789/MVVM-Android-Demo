package com.mercari.api

import com.mercari.base.di.DaggerStrike
import com.mercari.business.*
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function3
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class ApiManager {
    init {
        DaggerStrike.doSimpleInjection().here(this)

    }

    @Inject
    lateinit var retrofit: Retrofit


    private val categoryApi = retrofit.create(CategoryApi::class.java)


    fun getData(categoryData: (List<CategoryData>?) -> Unit) {
        categoryApi.getData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy({
            categoryData(null)
        }, {
            categoryData(it)
        })
    }

    fun getCategories(data: (Categories?) -> Unit): Disposable {
        return Single.zip(
            categoryApi.getAllCategory(),
            categoryApi.getMenCategory(),
            categoryApi.getWomenCategory(),
            Function3<List<Category>, List<MenCategory>, List<WomenCategory>, Categories> { t1, t2, t3 ->
                Categories(t1, t2, t3)
            }


        ).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy({
            data(null)
        }, {
            data(it)
        })
    }


}