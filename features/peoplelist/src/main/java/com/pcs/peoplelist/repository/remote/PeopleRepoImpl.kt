package com.pcs.peoplelist.repository.remote

import com.pcs.peoplelist.repository.model.People
import com.pcs.peoplelist.repository.service.ApiService
import com.pcs.common.network.Result

/**
Created by ikbaltoriq on 28,August,2024
 **/
class PeopleRepoImpl(private var apiService: ApiService ): PeopleRepo {
    override suspend fun getDataPeople(): Result<MutableList<People>> {
        return try {
            val response = apiService.getDataPeople()
            if (response.isSuccessful) {
                Result.Success(response.body() ?: mutableListOf())
            } else {
                Result.Error(Exception("Failed to load posts"))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}