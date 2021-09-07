package com.evaneos.evaneostest.di

import com.evaneos.destinations_list.data.di.DestinationsListRepositoryModule
import com.evaneos.destinations_list.domain.interactor.FetchDestinationsListInteractor
import com.evaneos.destinations_list.domain.repository.DestinationsListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DestinationsListRepositoryModule::class])
@InstallIn(SingletonComponent::class)
object InteractorModule {
    @Provides
    fun provideFetchDestinationsListInteractor(
        repository: DestinationsListRepository
    ): FetchDestinationsListInteractor {
        return FetchDestinationsListInteractor(repository)
    }
}

