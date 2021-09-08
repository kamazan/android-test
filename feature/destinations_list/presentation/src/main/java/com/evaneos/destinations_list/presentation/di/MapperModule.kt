package com.evaneos.destinations_list.presentation.di

import com.evaneos.common.data.mapper.Mapper
import com.evaneos.destinations_list.presentation.mapper.DomainDestinationToDestinationMapper
import com.evaneos.destinations_list.presentation.model.Destination
import com.evaneos.destinations_list.domain.model.Destination as DomainDestination
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {
    @Provides
    fun providePresentationDestinationMapper(): Mapper<DomainDestination, Destination> {
        return DomainDestinationToDestinationMapper()
    }
}