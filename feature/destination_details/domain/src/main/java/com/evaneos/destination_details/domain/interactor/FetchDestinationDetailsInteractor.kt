package com.evaneos.destination_details.domain.interactor

import com.evaneos.destination_details.domain.model.DestinationDetails
import com.evaneos.destination_details.domain.repository.DestinationDetailsRepository

class FetchDestinationDetailsInteractor(private val destinationDetailsRepository: DestinationDetailsRepository) {
    suspend fun fetchDestinationDetails(destinationId: Long): DestinationDetails {
        return destinationDetailsRepository.fetchDestinationDetails(destinationId)
    }
}
