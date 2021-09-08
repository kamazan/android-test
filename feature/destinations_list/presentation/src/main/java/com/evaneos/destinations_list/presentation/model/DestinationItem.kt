package com.evaneos.destinations_list.presentation.model

sealed class DestinationItem(val type: Type) {

    enum class Type {
        DESTINATION_CARD,
        EMPTY_MESSAGE
    }

    data class DestinationCardItem(val destination: Destination) :
        DestinationItem(Type.DESTINATION_CARD)

    object DestinationEmptyMessageItem : DestinationItem(Type.EMPTY_MESSAGE)
}
