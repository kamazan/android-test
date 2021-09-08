package com.evaneos.destinations_list.presentation.mapper

import com.evaneos.destinations_list.presentation.DestinationFixtures
import com.evaneos.destinations_list.presentation.model.DestinationItem
import io.mockk.MockKAnnotations
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class DestinationItemsMapperTest {
    private lateinit var mapper: DestinationItemsMapper

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        mapper = DestinationItemsMapper()
    }

    @Test
    fun `DestinationItemsMapperTest should wrap destinations inside DestinationCardItem`() {
        val size = 10
        val destinations = DestinationFixtures.getDestinations(size)

        val items = mapper(destinations)
        assertEquals(size, items.count { it is DestinationItem.DestinationCardItem })
    }

    @Test
    fun `DestinationItemsMapperTest should return a list with a DestinationEmptyMessageItem when destinations are not available`() {
        val items = mapper(listOf())
        assertEquals(1, items.size)
        assertTrue(items.all { item -> item is DestinationItem.DestinationEmptyMessageItem })
    }
}