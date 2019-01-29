package com.mercari.base.di

import com.mercari.base.BaseActivity
import com.mercari.base.di.components.*
import com.mercari.base.di.modules.ActivityModule
import com.mercari.base.di.modules.AppModule
import com.mercari.base.di.modules.ObjectModule


object DaggerStrike {
    private var injector: AppComponent? = null
    private var simpleInjector: NonAndroidComponent? = null

    fun doAppComponentInjection(): AppComponent {

        if (injector == null || injector !is AppComponent) {
            injector = DaggerAppComponent.builder().appModule(AppModule()).build()
        }
        return injector!!
    }

    fun doActivityComponentInjection(baseActivity: BaseActivity): ActivityComponent {

        if (injector == null || injector !is ActivityComponent) {
            injector = DaggerActivityComponent.builder().activityModule(ActivityModule()).build()
        }
        return (injector as ActivityComponent)
    }


    fun doSimpleInjection(): NonAndroidComponent {
        if (simpleInjector == null)
            simpleInjector = DaggerNonAndroidComponent.builder().objectModule(ObjectModule()).build()
        return simpleInjector!!
    }


}
