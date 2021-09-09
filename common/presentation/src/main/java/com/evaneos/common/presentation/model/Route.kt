package com.evaneos.common.presentation.model

sealed class Route {
    data class DestinationDetails(val destinationId: Long, val destinationName: String): Route()
}