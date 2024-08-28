package com.pcs.peoplelist.repository.remote

import com.pcs.peoplelist.repository.model.People
import com.pcs.peoplelist.repository.service.ApiService
import retrofit2.Response

/**
Created by ikbaltoriq on 28,August,2024
 **/
class PeopleRepoImpl(private var apiService: ApiService ): PeopleRepo {
    override suspend fun getDataPeople(): Response<MutableList<People>> {
        return apiService.getDataPeople()
    }
}