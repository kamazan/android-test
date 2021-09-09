package com.evaneos.destination_details.data.mapper

import com.evaneos.common.data.mapper.Mapper
import io.mockk.MockKAnnotations
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import com.evaneos.data.model.DestinationDetails as ServiceDestinationDetails
import com.evaneos.destination_details.domain.model.DestinationDetails as DomainDestinationDetails

class ServiceDestinationDetailsToDestinationDetailsMapperTest {
    private lateinit var mapper: Mapper<ServiceDestinationDetails, DomainDestinationDetails>

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        mapper = ServiceDestinationDetailsToDestinationDetailsMapper()
    }

    @Test
    fun `ServiceDestinationDetailsToDestinationDetailsMapper maps Service destination details correctly`() {
        val serviceDestination = createDestinationDetails()
        val details = mapper.invoke(serviceDestination)

        assertEquals(details.id, DESTINATION_ID)
        assertEquals(details.name, DESTINATION_NAME)
        assertEquals(details.url, DESTINATION_URL)
    }

    companion object Fixtures {
        private const val DESTINATION_ID = 42L
        private const val DESTINATION_NAME = "Ann Arbor, MI"
        private const val DESTINATION_URL = "http://example.com"

        fun createDestinationDetails(): ServiceDestinationDetails {
            return ServiceDestinationDetails(
                id = DESTINATION_ID,
                name = DESTINATION_NAME,
                url = DESTINATION_URL
            )
        }
    }
}