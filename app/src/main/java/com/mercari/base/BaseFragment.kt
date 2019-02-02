package com.mercari.base

import androidx.fragment.app.Fragment

abstract class BaseFragment<T : Mercari> : Fragment() {
    abstract fun onUpdate(t: List<T>?)
}