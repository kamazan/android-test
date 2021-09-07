package com.evaneos.destinations_list.data.repository

import com.evaneos.common.data.mapper.Mapper
import com.evaneos.data.DestinationFetchingService
import com.evaneos.destinations_list.domain.model.Destination
import com.evaneos.data.model.Destination as FetchingServiceDestination
import com.evaneos.destinations_list.domain.repository.DestinationsListRepository
import javax.inject.Inject

class DestinationsListRepositoryImpl @Inject constructor(
    private val fetchingService: DestinationFetchingService,
    private val destinationsMapper: Mapper<FetchingServiceDestination, Destination>
) : DestinationsListRepository {
    override suspend fun fetchDestinationsList(): List<Destination> {
        return fetchingService.getDestinations().map { destinationsMapper(it) }
    }
}