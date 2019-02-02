package com.mercari.api

import com.mercari.base.di.DaggerStrike
import com.mercari.business.Category
import com.mercari.business.CategoryData
import com.mercari.business.MenCategory
import com.mercari.business.WomenCategory
import io.reactivex.android.schedulers.AndroidSchedulers
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


    fun getData(categoryData: (List<CategoryData>?) -> Unit) =
        categoryApi.getData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy({
            categoryData(null)
        }, {
            categoryData(it)
        })


    fun getAllCategory(categoryData: (List<Category>?) -> Unit) =
            categoryApi.getAllCategory().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy(
                    {
                        categoryData(null)
                    },
                    {
                        categoryData(it)
                    })


    fun getMenCategory(categoryData: (List<MenCategory>?) -> Unit) =
            categoryApi.getMenCategory().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy(
                    {
                        categoryData(null)
                    },
                    {
                        categoryData(it)
                    })

    fun getWomenCategory(categoryData: (List<WomenCategory>?) -> Unit) =
            categoryApi.getWomenCategory().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy(
                    {
                        categoryData(null)
                    },
                    {
                        categoryData(it)
                    })

// below RX implementation can be used for combined network requests which allow to fetch data from network concurrently.
//    fun getCategories(data: (Categories?) -> Unit): Disposable {
//        return Single.zip(
//            categoryApi.getAllCategory(),
//            categoryApi.getMenCategory(),
//            categoryApi.getWomenCategory(),
//            Function3<List<Category>, List<MenCategory>, List<WomenCategory>, Categories> { t1, t2, t3 ->
//                Categories(t1, t2, t3)
//            }
//
//
//        ).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy({
//            data(null)
//        }, {
//            data(it)
//        })
//    }


}