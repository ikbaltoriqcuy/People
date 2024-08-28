package com.pcs.peopledetail.di

import com.pcs.peopledetail.domain.usecase.PeopleDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
Created by ikbaltoriq on 28,August,2024
 **/

@Module
@InstallIn(SingletonComponent::class)
object PeopleDetailModule {

    @Singleton
    @Provides
    fun providePeopleDetailUseCase(): PeopleDetailUseCase = PeopleDetailUseCase()

}