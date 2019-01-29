package com.mercari.base

import androidx.lifecycle.ViewModel
import com.mercari.ui.MercariUI

abstract class BaseViewModel<UI : MercariUI> : ViewModel() {

    private var appUI: UI? = null

    fun attachUI(ui: UI) {
        appUI = ui
    }

    override fun onCleared() {
        appUI = null
    }

    fun getUI() = appUI!!

}