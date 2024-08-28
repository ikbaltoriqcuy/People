package com.pcs.peoplelist.di

import com.pcs.peoplelist.domain.usecase.GetDataPeopleUseCase
import com.pcs.peoplelist.repository.remote.PeopleRepoImpl
import com.pcs.peoplelist.repository.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

/**
Created by ikbaltoriq on 28,August,2024
 **/

@Module
@InstallIn(SingletonComponent::class)
object PeopleListModule {

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun providesRepository(apiService: ApiService) = PeopleRepoImpl(apiService)

    @Singleton
    @Provides
    fun providesGetDataPeopleUseCase(repo: PeopleRepoImpl) = GetDataPeopleUseCase(repo)

}