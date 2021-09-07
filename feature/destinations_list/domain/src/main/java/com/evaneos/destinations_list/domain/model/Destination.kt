package com.evaneos.destinations_list.domain.model

data class Destination(
    val id: Long,
    val name: String,
    val pictureUrl: String,
    val tag: String?,
    val rating: Int,
)