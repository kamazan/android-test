package com.evaneos.destinations_list.domain.interactor

import com.evaneos.destinations_list.domain.model.Destination
import com.evaneos.destinations_list.domain.repository.DestinationsListRepository

class FetchDestinationsListInteractor(private val destinationsListRepository: DestinationsListRepository) {
    suspend fun fetchDestinationsList(): List<Destination> {
        return destinationsListRepository.fetchDestinationsList().sortedBy { it.name }
    }
}

