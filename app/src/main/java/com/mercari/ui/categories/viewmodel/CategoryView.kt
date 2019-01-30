package com.mercari.ui.categories.viewmodel

import com.mercari.business.Categories
import com.mercari.business.CategoryData
import com.mercari.ui.MercariUI

interface CategoryView : MercariUI {
    fun onCategoryDataReceived(categoriesData: List<CategoryData>)
    fun onCategoriesReceived(categories: Categories)
    fun onError()
}