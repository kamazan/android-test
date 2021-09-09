package com.evaneos.destination_details.data.repository

import com.evaneos.common.data.mapper.Mapper
import com.evaneos.data.DestinationFetchingService
import com.evaneos.destination_details.data.repository.DestinationDetailsRepositoryImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import com.evaneos.data.model.DestinationDetails as ServiceDestinationDetails
import com.evaneos.destination_details.domain.model.DestinationDetails

class DestinationDetailsRepositoryImplTest {
    private lateinit var destinationDetailsRepositoryImpl: DestinationDetailsRepositoryImpl

    @MockK
    private lateinit var fetchingService: DestinationFetchingService

    @MockK
    private lateinit var mapper: Mapper<ServiceDestinationDetails, DestinationDetails>

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        destinationDetailsRepositoryImpl = DestinationDetailsRepositoryImpl(fetchingService, mapper)
    }

    @Test
    fun `DestinationDetailsRepositoryImpl should fetch details with the correct id and map it`() = runBlocking {
        val destinationId = 42L
        coEvery { fetchingService.getDestinationDetails(any()) } answers { ServiceDestinationDetails(destinationId, "", "") }
        coEvery { mapper.invoke(any()) } answers { mockk() }

        destinationDetailsRepositoryImpl.fetchDestinationDetails(destinationId)

        coVerify(exactly = 1) { fetchingService.getDestinationDetails(destinationId) }
        coVerify(exactly = 1) { mapper.invoke(any()) }
    }
}