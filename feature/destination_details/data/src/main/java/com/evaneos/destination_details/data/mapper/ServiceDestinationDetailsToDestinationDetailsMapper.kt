package com.evaneos.destination_details.data.mapper

import com.evaneos.common.data.mapper.Mapper
import com.evaneos.destination_details.domain.model.DestinationDetails
import com.evaneos.data.model.DestinationDetails as ServiceDestinationDetails

class ServiceDestinationDetailsToDestinationDetailsMapper: Mapper<ServiceDestinationDetails, DestinationDetails> {
    override fun invoke(obj: ServiceDestinationDetails): DestinationDetails {
        return obj.run {
            DestinationDetails(
                id = id,
                name = name,
                url = url,
            )
        }
    }
}