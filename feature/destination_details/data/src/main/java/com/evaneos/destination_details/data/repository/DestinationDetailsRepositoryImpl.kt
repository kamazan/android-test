package com.evaneos.destination_details.data.repository

import com.evaneos.common.data.mapper.Mapper
import com.evaneos.data.DestinationFetchingService
import com.evaneos.destination_details.domain.model.DestinationDetails
import com.evaneos.destination_details.domain.repository.DestinationDetailsRepository
import com.evaneos.data.model.DestinationDetails as ServiceDestinationDetails
import javax.inject.Inject

class DestinationDetailsRepositoryImpl @Inject
constructor(
    private val fetchingService: DestinationFetchingService,
    private val destinationDetailsMapper: Mapper<ServiceDestinationDetails, DestinationDetails>
) : DestinationDetailsRepository {

    override suspend fun fetchDestinationDetails(destinationId: Long): DestinationDetails {
        return destinationDetailsMapper(fetchingService.getDestinationDetails(destinationId))
    }

}