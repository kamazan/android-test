package com.evaneos.destinations_list.presentation.mapper

import com.evaneos.common.data.mapper.Mapper
import com.evaneos.destinations_list.presentation.model.Destination
import com.evaneos.destinations_list.domain.model.Destination as DomainDestination
import io.mockk.MockKAnnotations
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DomainDestinationToDestinationMapperTest {
    private lateinit var mapper: Mapper<DomainDestination, Destination>

    @Before
    fun setUp() {
        mapper = DomainDestinationToDestinationMapper()
    }

    @Test
    fun `DomainDestinationToDestinationMapperTest maps Domain destinations correctly`() {
        val id = 1L
        val name = "Paris"
        val pictureUrl = "https://example.com"
        val tag = "Tag"
        val rating = 5
        val floatRating = 5f

        val domainDestination = DomainDestination(id, name, pictureUrl, tag, rating)
        val destination = mapper.invoke(domainDestination)

        Assert.assertEquals(id, destination.id)
        Assert.assertEquals(name, destination.name)
        Assert.assertEquals(pictureUrl, destination.pictureUrl)
        Assert.assertEquals(tag, destination.tag)
        Assert.assertEquals(floatRating, destination.rating)
    }
}