package com.mercari.api

import com.mercari.business.Category
import com.mercari.business.CategoryData
import com.mercari.business.MenCategory
import com.mercari.business.WomenCategory
import io.reactivex.Single
import retrofit2.http.GET

interface CategoryApi {
    @GET("master.json")
    fun getData(): Single<List<CategoryData>>

    @GET("men.json")
    fun getMenCategory(): Single<List<MenCategory>>

    @GET("women.json")
    fun getWomenCategory(): Single<List<WomenCategory>>

    @GET("all.json")
    fun getAllCategory(): Single<List<Category>>
}