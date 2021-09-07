package com.evaneos.destinations_list.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.evaneos.common.presentation.model.RequestStatus
import com.evaneos.common.presentation.model.Route
import com.evaneos.common.test.utils.getOrAwaitValue
import com.evaneos.destinations_list.domain.interactor.FetchDestinationsListInteractor
import com.evaneos.destinations_list.domain.model.Destination
import com.evaneos.destinations_list.presentation.viewmodel.DestinationsListViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class DestinationsListViewModelTest {
    lateinit var viewModel: DestinationsListViewModel

    private val fetchDestinationsListInteractor: FetchDestinationsListInteractor = mockk()


    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = com.evaneos.common.test.utils.MainCoroutineRule()

    @Before
    fun setUp() {
        viewModel = DestinationsListViewModel(fetchDestinationsListInteractor)
    }

    @Test
    fun `DestinationsListViewModel should update destinations on load call`() = runBlocking {
        val destinations = Fixtures.destinations
        coEvery { fetchDestinationsListInteractor.fetchDestinationsList() } answers { destinations }

        viewModel.load()
        assertEquals(destinations, viewModel.destinations.getOrAwaitValue())
    }

    @Test
    fun `DestinationsListViewModel should update route to DestinationsDetails on selectDestination call`() {
        val destination = Fixtures.destination

        viewModel.selectDestination(destination)
        assertEquals(Route.DestinationDetails(destination.id), viewModel.route.getOrAwaitValue())
    }


    object Fixtures {
        val destination = Destination(1L, "", "", "", 2)
        val destinations: List<Destination> by lazy {
            listOf(destination)
        }
    }
}
