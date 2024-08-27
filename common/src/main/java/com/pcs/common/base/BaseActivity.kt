package com.pcs.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
Created by ikbaltoriq on 27,August,2024
 **/
abstract class BaseActivity<T>: AppCompatActivity() {
    val binding: T by lazy { DataBindingUtil.setContentView(this, layoutId()) }

    abstract fun layoutId(): Int
    abstract fun onCreate()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding?.let {
            (binding as ViewDataBinding).lifecycleOwner = this@BaseActivity
        }
        onCreate()
    }

}