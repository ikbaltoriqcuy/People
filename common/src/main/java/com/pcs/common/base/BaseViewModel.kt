package com.pcs.common.base

import androidx.lifecycle.ViewModel
import com.pcs.common.utils.NonNullLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel

/**
Created by ikbaltoriq on 27,August,2024
 **/
class BaseViewModel: ViewModel() {
    private val job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    private val _isLoading = NonNullLiveData<Boolean>()
    val isLoading: NonNullLiveData<Boolean> get() = _isLoading

    private val _errorMessage = NonNullLiveData<String>()
    val errorMessage: NonNullLiveData<String> get() = _errorMessage

    fun setIsLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

    fun setErrorMessage(errorMessage:  String) {
        _errorMessage.value = errorMessage
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}