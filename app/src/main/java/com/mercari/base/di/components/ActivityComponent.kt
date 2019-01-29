package com.mercari.base.di.components

import com.mercari.base.di.modules.ActivityModule
import com.mercari.base.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ActivityModule::class])
interface ActivityComponent : AppComponent