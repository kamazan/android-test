package com.evaneos.destinations_list.data

import com.evaneos.data.model.Destination

object Fixtures {
    const val DESTINATION_ID = 42L
    const val DESTINATION_NAME = "Ann Arbor, MI"
    const val DESTINATION_PICTURE_URL = "www.example.com"
    const val DESTINATION_TAG = "Insolite"
    const val DESTINATION_RATING = 4

    internal fun createDestination(): Destination {
        return Destination(
            id = DESTINATION_ID,
            name = DESTINATION_NAME,
            pictureUrl = DESTINATION_PICTURE_URL,
            tag = DESTINATION_TAG,
            rating = DESTINATION_RATING,
        )
    }
}