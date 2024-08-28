package com.pcs.peopledetail.ui

import com.pcs.common.base.BaseViewModel
import com.pcs.common.utils.NonNullLiveData
import com.pcs.peopledetail.domain.usecase.PeopleDetailUseCase
import com.pcs.peopledetail.repository.model.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
Created by ikbaltoriq on 28,August,2024
 **/

@HiltViewModel
class PeopleDetailViewModel @Inject constructor(
    private val peopleUseCase: PeopleDetailUseCase
): BaseViewModel() {

    private var _person = NonNullLiveData<Person>()
    val person: NonNullLiveData<Person> get() = _person

    private var _imgAvatar = NonNullLiveData<String>()
    val imgAvatar: NonNullLiveData<String> get() = _imgAvatar

    fun setPerson(data: String) {
        val person: Person = peopleUseCase.getPerson(data)

        _imgAvatar.value = person.avatar
        _person.value = person
    }
    fun getFirstName(): String {
        return peopleUseCase.getFirstName(person.value.name)
    }

    fun getLastName(): String {
        return peopleUseCase.getLastName(person.value.name)
    }

    fun getAddress(): String {
        return peopleUseCase.getAddress(person.value)
    }
}