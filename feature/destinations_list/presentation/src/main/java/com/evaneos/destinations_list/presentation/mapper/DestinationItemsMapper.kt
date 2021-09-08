package com.evaneos.destinations_list.presentation.mapper

import com.evaneos.common.data.mapper.Mapper
import com.evaneos.destinations_list.presentation.model.Destination
import com.evaneos.destinations_list.presentation.model.DestinationItem

class DestinationItemsMapper: Mapper<List<Destination>, List<DestinationItem>> {
    override fun invoke(obj: List<Destination>): List<DestinationItem> {
        val cardItems = obj.map { destination ->
            DestinationItem.DestinationCardItem(destination)
        }

        return when (cardItems.isEmpty()) {
            true -> listOf(DestinationItem.DestinationEmptyMessageItem)
            false -> cardItems
        }
    }
}