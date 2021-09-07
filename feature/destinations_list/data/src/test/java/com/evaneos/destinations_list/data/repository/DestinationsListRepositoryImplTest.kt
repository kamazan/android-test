package com.evaneos.destinations_list.data.repository

import com.evaneos.common.data.mapper.Mapper
import com.evaneos.data.DestinationFetchingService
import com.evaneos.destinations_list.data.Fixtures
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import com.evaneos.data.model.Destination as ServiceDestination
import com.evaneos.destinations_list.domain.model.Destination as DomainDestination

class DestinationsListRepositoryImplTest {
    private lateinit var destinationsListRepositoryImpl: DestinationsListRepositoryImpl

    @MockK
    private lateinit var fetchingService: DestinationFetchingService

    @MockK
    private lateinit var mapper: Mapper<ServiceDestination, DomainDestination>

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        destinationsListRepositoryImpl = DestinationsListRepositoryImpl(fetchingService, mapper)
    }

    @Test
    fun `DestinationsListRepositoryImpl fetches results and maps them`() = runBlocking {
        val expected = listOf(Fixtures.createDestination())
        coEvery { fetchingService.getDestinations() } answers { expected }
        coEvery { mapper.invoke(any()) } answers { mockk() }

        destinationsListRepositoryImpl.fetchDestinationsList()

        coVerify(exactly = 1) { fetchingService.getDestinations() }
        coVerify(exactly = expected.size) { mapper.invoke(any()) }
    }

    @Test
    fun `DestinationsListRepositoryImpl handles empty results`() = runBlocking {
        val expected = listOf<ServiceDestination>()
        coEvery { fetchingService.getDestinations() } answers { expected }
        coEvery { mapper.invoke(any()) } answers { mockk() }

        val destinations = destinationsListRepositoryImpl.fetchDestinationsList()

        coVerify(exactly = 1) { fetchingService.getDestinations() }
        coVerify(exactly = 0) { mapper.invoke(any()) }
        assertEquals(destinations, emptyList<DomainDestination>())
    }
}