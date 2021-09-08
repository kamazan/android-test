package com.evaneos.destinations_list.presentation.mapper

import com.evaneos.common.data.mapper.Mapper
import com.evaneos.destinations_list.presentation.model.Destination
import com.evaneos.destinations_list.domain.model.Destination as DomainDestination

class DomainDestinationToDestinationMapper: Mapper<DomainDestination, Destination> {
    override fun invoke(obj: DomainDestination): Destination {
        return obj.run {
            Destination(
                id = id,
                name = name,
                pictureUrl = pictureUrl,
                tag = tag,
                rating = rating.toFloat(),
            )
        }
    }
}