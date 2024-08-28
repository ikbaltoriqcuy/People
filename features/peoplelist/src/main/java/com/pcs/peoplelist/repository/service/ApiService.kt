package com.pcs.peoplelist.repository.service

import com.pcs.peoplelist.repository.model.People
import retrofit2.Response
import retrofit2.http.GET

/**
Created by ikbaltoriq on 28,August,2024
 **/
interface ApiService {
    @GET("getData/test")
    suspend fun getDataPeople(): Response<MutableList<People>>
}