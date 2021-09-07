package com.evaneos.destinations_list.interactor

import com.evaneos.destinations_list.domain.interactor.FetchDestinationsListInteractor
import com.evaneos.destinations_list.domain.model.Destination
import com.evaneos.destinations_list.domain.repository.DestinationsListRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FetchDestinationsListInteractorTest {
    @MockK
    private lateinit var destinationsListRepository: DestinationsListRepository

    private lateinit var fetchDestinationsListInteractor: FetchDestinationsListInteractor

    private val unsortedDestinations = listOf(
        Destination(2L, "B", "", "", 0),
        Destination(3L, "C", "", "", 0),
        Destination(1L, "A", "", "", 0),
    )

    private val sortedDestinations = listOf(
        Destination(1L, "A", "", "", 0),
        Destination(2L, "B", "", "", 0),
        Destination(3L, "C", "", "", 0),
    )

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        fetchDestinationsListInteractor = FetchDestinationsListInteractor(destinationsListRepository)
    }

    @Test
    fun `FetchDestinationsListInteractor should fetch with repository and sort destinations`() = runBlocking {
        val expected = unsortedDestinations
        coEvery { destinationsListRepository.fetchDestinationsList() } answers { expected }

        val destinations = fetchDestinationsListInteractor.fetchDestinationsList()

        coVerify(exactly = 1) { destinationsListRepository.fetchDestinationsList() }
        assertEquals(sortedDestinations, destinations)
    }
}