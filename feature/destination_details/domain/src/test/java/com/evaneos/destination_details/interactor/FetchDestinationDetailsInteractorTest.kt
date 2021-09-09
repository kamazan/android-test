package com.evaneos.destination_details.interactor

import com.evaneos.destination_details.domain.interactor.FetchDestinationDetailsInteractor
import com.evaneos.destination_details.domain.model.DestinationDetails
import com.evaneos.destination_details.domain.repository.DestinationDetailsRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FetchDestinationDetailsInteractorTest {
    @MockK
    private lateinit var destinationDetailsRepository: DestinationDetailsRepository

    private lateinit var fetchDestinationDetailsInteractor: FetchDestinationDetailsInteractor

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        fetchDestinationDetailsInteractor = FetchDestinationDetailsInteractor(destinationDetailsRepository)
    }

    @Test
    fun `FetchDestinationDetailsInteractor should fetch details of the correct destination with repository`() = runBlocking {
        val destinationId = 42L
        val expected = DestinationDetails(destinationId, "", "")
        coEvery { destinationDetailsRepository.fetchDestinationDetails(destinationId) } answers { expected }

        val result = fetchDestinationDetailsInteractor.fetchDestinationDetails(destinationId)

        coVerify(exactly = 1) { destinationDetailsRepository.fetchDestinationDetails(destinationId) }
        assertEquals(expected, result)
    }
}