package com.pcs.common.utils

import androidx.lifecycle.MutableLiveData

/**
Created by ikbaltoriq on 27,August,2024
 **/
class NonNullLiveData<T>: MutableLiveData<T>() {
    override fun setValue(value: T?) {
        if (value != null)
            super.setValue(value)
    }

    override fun postValue(value: T?) {
        if (value != null)
            super.postValue(value)
    }

    override fun getValue(): T {
        return super.getValue()!!
    }
}