package com.pcs.peoplelist.repository.remote

import com.pcs.peoplelist.repository.model.People
import retrofit2.Response

/**
Created by ikbaltoriq on 28,August,2024
 **/
interface PeopleRepo {
    suspend fun getDataPeople(): Response<MutableList<People>>
}