package com.pcs.common.utils

import android.view.View

/**
Created by ikbaltoriq on 27,August,2024
 **/
object ViewUtils {

    private const val CLICK_DELAY = 1000
    fun View.onSetClickOnce(onAction: () -> Unit) {
        var lastClick = 0L
        this.setOnClickListener {
            if (System.currentTimeMillis() - lastClick >= CLICK_DELAY) {
                lastClick = System.currentTimeMillis()
                onAction.invoke()
            }
        }
    }
}