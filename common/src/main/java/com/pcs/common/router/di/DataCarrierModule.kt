package com.pcs.common.router.di

import com.pcs.common.router.DataCarrier
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
object DataCarrierModule {
    @Singleton
    @Provides
    fun provideDataCarrier(): DataCarrier {
        return DataCarrier()
    }
}