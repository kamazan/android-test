package com.evaneos.data

import com.evaneos.data.factory.DataFactory
import com.evaneos.data.model.Destination
import com.evaneos.data.model.DestinationDetails

class FakeDestinationFetchingService : DestinationFetchingService {
    override suspend fun getDestinations() : List<Destination> {
        return DataFactory.createDestinationList()
    }

    override suspend fun getDestinationDetails(id: Long) : DestinationDetails {
        return DataFactory.getDestinationDetails(id)
    }
}