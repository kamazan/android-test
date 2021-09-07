package com.evaneos.destinations_list.data.mapper

import com.evaneos.common.data.mapper.Mapper
import com.evaneos.destinations_list.data.Fixtures
import io.mockk.MockKAnnotations
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import com.evaneos.data.model.Destination as ServiceDestination
import com.evaneos.destinations_list.domain.model.Destination as DomainDestination

class ServiceDestinationToDomainDestinationMapperTest {
    private lateinit var mapper: Mapper<ServiceDestination, DomainDestination>

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        mapper = ServiceDestinationToDomainDestinationMapper()
    }

    @Test
    fun `ServiceDestinationToDomainDestinationMapper maps Service destinations correctly`() {
        val serviceDestination = Fixtures.createDestination()
        val destination = mapper.invoke(serviceDestination)

        assertEquals(destination.id, Fixtures.DESTINATION_ID)
        assertEquals(destination.name, Fixtures.DESTINATION_NAME)
        assertEquals(destination.pictureUrl, Fixtures.DESTINATION_PICTURE_URL)
        assertEquals(destination.tag, Fixtures.DESTINATION_TAG)
        assertEquals(destination.rating, Fixtures.DESTINATION_RATING)
    }
}