package com.mercari.utils

import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation

object UIAnimationUtils {

    fun applyFadeInFadeOut(v: View) {
        val fadeOut = AlphaAnimation(1f, 0f)
        fadeOut.duration = 1000
        fadeOut.repeatCount = Animation.INFINITE
        fadeOut.repeatMode = Animation.REVERSE
        v.startAnimation(fadeOut)

    }
}