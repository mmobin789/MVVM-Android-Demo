package com.mercari.api

import retrofit2.http.GET

interface CategoryApi {
    @GET("men.json")
    fun getMenCategory()

    @GET("women.json")
    fun getWomenCategory()

    @GET("all.json")
    fun getAllCategory()
}