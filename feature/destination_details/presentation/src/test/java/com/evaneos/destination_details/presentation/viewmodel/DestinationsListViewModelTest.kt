package com.evaneos.destination_details.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.evaneos.common.test.utils.MainCoroutineRule
import com.evaneos.common.test.utils.getOrAwaitValue
import com.evaneos.destination_details.domain.interactor.FetchDestinationDetailsInteractor
import com.evaneos.destination_details.domain.model.DestinationDetails
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Before
import org.junit.Rule

class DestinationsListViewModelTest {
    private val fetchDestinationDetailsInteractor: FetchDestinationDetailsInteractor = mockk()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()


    @Test
    fun `DestinationDetailsViewModel should update url on load call`() = runBlocking {

        val details = createDestinationDetails()

        coEvery { fetchDestinationDetailsInteractor.fetchDestinationDetails(DESTINATION_ID) } answers { details }

        val viewModel = DestinationDetailsViewModel(DESTINATION_ID, fetchDestinationDetailsInteractor)

        coVerify(exactly = 1) { fetchDestinationDetailsInteractor.fetchDestinationDetails(
            DESTINATION_ID)  }
        assertEquals(DESTINATION_URL, viewModel.destinationUrlPage.getOrAwaitValue())
    }

    companion object Fixtures {
        private const val DESTINATION_ID = 42L
        private const val DESTINATION_NAME = "Ann Arbor, MI"
        private const val DESTINATION_URL = "http://destination.com"

        private fun createDestinationDetails(): DestinationDetails {
            return DestinationDetails(
                id = DESTINATION_ID,
                name = DESTINATION_NAME,
                url = DESTINATION_URL
            )
        }
    }
}
