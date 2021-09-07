package com.evaneos.destinations_list.domain.repository

import com.evaneos.destinations_list.domain.model.Destination

interface DestinationsListRepository {
    suspend fun fetchDestinationsList(): List<Destination>
}