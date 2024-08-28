package com.pcs.peoplelist.ui.peoplelist

import com.pcs.common.base.BaseViewModel
import com.pcs.common.network.Result
import com.pcs.common.utils.NonNullLiveData
import com.pcs.peoplelist.domain.usecase.GetDataPeopleUseCase
import com.pcs.peoplelist.repository.model.People
import com.pcs.peoplelist.repository.remote.PeopleRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

/**
Created by ikbaltoriq on 28,August,2024
 **/

@HiltViewModel
class PeopleListViewModel @Inject constructor(
    private val getDataPeopleUseCase: GetDataPeopleUseCase
): BaseViewModel() {

    private val _peopleList = NonNullLiveData<MutableList<People>>()
    val peopleList: NonNullLiveData<MutableList<People>> get() = _peopleList


    private val _isDataPeopleEmpty = NonNullLiveData<Boolean>().apply { value = true }
    val isDataPeopleEmpty: NonNullLiveData<Boolean> get() = _isDataPeopleEmpty

    init {
        getDataPeople()
    }

    fun getDataPeople() {
        coroutineScope.launch {
            setIsLoading(true)
            val result = getDataPeopleUseCase.invoke()

            when(result) {
                is Result.Success -> {
                    _peopleList.value = result.data
                    _isDataPeopleEmpty.value = peopleList.value.size == 0
                    setIsLoading(false)
                }
                is Result.Error -> {
                    setErrorMessage(result.exception.message.toString().orEmpty())
                    setIsLoading(false)
                }
                else -> {}
            }
        }
    }
}