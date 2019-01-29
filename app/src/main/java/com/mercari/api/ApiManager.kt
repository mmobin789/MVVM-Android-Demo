package com.mercari.api

import com.mercari.base.di.DaggerStrike
import retrofit2.Retrofit
import javax.inject.Inject

object ApiManager {
    init {
        DaggerStrike.doSimpleInjection().here(this)
    }

    @Inject
    lateinit var retrofit: Retrofit

    private val categoryApi = retrofit.create(CategoryApi::class.java)


    fun getMenCategory() {

    }


    fun getWomenCategory() {

    }

    fun getAllCategory() {

    }

}