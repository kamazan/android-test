package com.evaneos.destination_details.domain.repository

import com.evaneos.destination_details.domain.model.DestinationDetails

interface DestinationDetailsRepository {
    suspend fun fetchDestinationDetails(destinationId: Long): DestinationDetails
}