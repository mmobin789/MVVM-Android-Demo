package com.mercari.business

import com.google.gson.annotations.SerializedName

data class MenCategory(
    val id: String, val name: String, val status: String, @SerializedName("num_likes") val likes: Int,
    @SerializedName("num_comments") val comments: Int, val price: Float, val photo: String
)