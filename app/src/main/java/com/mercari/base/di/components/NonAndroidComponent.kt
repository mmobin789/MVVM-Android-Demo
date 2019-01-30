package com.mercari.base.di.components

import com.mercari.api.ApiManager
import com.mercari.base.di.modules.ObjectModule
import com.mercari.ui.categories.viewmodel.CategoryViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ObjectModule::class])
interface NonAndroidComponent {
    fun here(apiManager: ApiManager)
    fun here(categoryViewModel: CategoryViewModel)
}