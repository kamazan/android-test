package com.evaneos.destination_details.data.di

import com.evaneos.common.data.mapper.Mapper
import com.evaneos.data.model.DestinationDetails
import com.evaneos.destination_details.data.mapper.ServiceDestinationDetailsToDestinationDetailsMapper
import com.evaneos.destination_details.data.repository.DestinationDetailsRepositoryImpl
import com.evaneos.destination_details.domain.repository.DestinationDetailsRepository
import com.evaneos.destination_details.domain.model.DestinationDetails as DomainDestinationDetails
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DestinationDetailsDataModule {
    @Provides
    fun provideDestinationDetailsMapper(): Mapper<DestinationDetails, DomainDestinationDetails> {
        return ServiceDestinationDetailsToDestinationDetailsMapper()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class DestinationDetailsRepositoryModule {
    @Binds
    abstract fun bindDestinationDetailsRepository(
        destinationDetailsRepositoryImpl: DestinationDetailsRepositoryImpl
    ): DestinationDetailsRepository
}