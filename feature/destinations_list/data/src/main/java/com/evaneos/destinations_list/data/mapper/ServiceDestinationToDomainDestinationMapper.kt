package com.evaneos.destinations_list.data.mapper

import com.evaneos.common.data.mapper.Mapper
import com.evaneos.destinations_list.domain.model.Destination as DomainDestination
import com.evaneos.data.model.Destination as ServiceDestination

class ServiceDestinationToDomainDestinationMapper :
    Mapper<ServiceDestination, DomainDestination> {
    override fun invoke(obj: ServiceDestination): DomainDestination {
        return obj.run {
            DomainDestination(
                id = id,
                name = name,
                pictureUrl = pictureUrl,
                tag = tag,
                rating = rating,
            )
        }
    }
}
