package com.evaneos.destinations_list.data.di

import com.evaneos.destinations_list.data.repository.DestinationsListRepositoryImpl
import com.evaneos.destinations_list.domain.repository.DestinationsListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DestinationsListRepositoryModule {
    @Binds
    abstract fun bindDestinationsListRepository(
        destinationsListRepositoryImpl: DestinationsListRepositoryImpl
    ): DestinationsListRepository

}