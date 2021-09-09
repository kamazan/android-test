package com.evaneos.common.data.di

import com.evaneos.data.DestinationFetchingService
import com.evaneos.data.FakeDestinationFetchingService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DestinationsListDataModule {
    @Provides
    fun provideDestinationFetchingService(): DestinationFetchingService {
        return FakeDestinationFetchingService()
    }
}