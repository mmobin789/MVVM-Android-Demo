package com.mercari.ui.categories.viewmodel

import com.mercari.base.MercariError
import com.mercari.business.Category
import com.mercari.business.CategoryData
import com.mercari.business.MenCategory
import com.mercari.business.WomenCategory
import com.mercari.ui.MercariUI

interface CategoryView : MercariUI {
    fun onCategoryDataReceived(categoriesData: List<CategoryData>)
    // fun onCategoriesReceived(categories: Categories)
    fun onAllCategoryReady(category: List<Category>)

    fun onMenCategoryReady(category: List<MenCategory>)
    fun onWomenCategoryReady(category: List<WomenCategory>)
    fun onError(mercariError: MercariError)  // a message from the relevant request containing error is required.
}