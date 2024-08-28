package com.pcs.peopledetail.domain.usecase

import com.google.gson.Gson
import com.pcs.peopledetail.repository.model.Person
import javax.inject.Inject

/**
Created by ikbaltoriq on 28,August,2024
 **/
class PeopleDetailUseCase @Inject constructor() {
    fun getPerson(data: String): Person {
        val person: Person = try {
            Gson().fromJson(data, Person::class.java)
        } catch (e: Exception) {
            Person()
        }

        return person
    }
    fun getFirstName(fullName: String): String {
        return try { fullName.split(" ")[0] } catch (e: Exception) { "" }
    }

    fun getLastName(fullName: String): String {
        return try { fullName.split(" ")[1] } catch (e: Exception) { "" }
    }

    fun getAddress(person: Person): String {
        val address: StringBuilder = StringBuilder()
        with(person) {
            address.append(addressNo)
            address.append(' ')
            address.append(street)
            address.appendLine()
            address.append(county)
            address.append(' ')
            address.appendLine()
            address.append(zipCode)
            address.append(' ')
            address.append(country)
        }
        return address.toString()
    }
}