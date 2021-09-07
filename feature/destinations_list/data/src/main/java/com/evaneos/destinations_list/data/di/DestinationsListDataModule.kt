package com.evaneos.destinations_list.data.di

import com.evaneos.common.data.mapper.Mapper
import com.evaneos.data.DestinationFetchingService
import com.evaneos.data.model.Destination as FetchingServiceDestination
import com.evaneos.data.FakeDestinationFetchingService
import com.evaneos.destinations_list.data.mapper.ServiceDestinationToDomainDestinationMapper
import dagger.Module
import com.evaneos.destinations_list.domain.model.Destination as DomainDestination
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DestinationsListDataModule {
    @Provides
    fun provideDestinationMapper(): Mapper<FetchingServiceDestination, DomainDestination> {
        return ServiceDestinationToDomainDestinationMapper()
    }

    @Provides
    fun provideDestinationFetchingService(): DestinationFetchingService {
        return FakeDestinationFetchingService()
    }
}