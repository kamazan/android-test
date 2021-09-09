package com.evaneos.destinations_list.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.evaneos.common.data.mapper.Mapper
import com.evaneos.common.presentation.model.Route
import com.evaneos.common.test.utils.getOrAwaitValue
import com.evaneos.destinations_list.domain.interactor.FetchDestinationsListInteractor
import com.evaneos.destinations_list.presentation.DestinationFixtures
import com.evaneos.destinations_list.domain.model.Destination as DomainDestination
import com.evaneos.destinations_list.presentation.model.Destination
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
    lateinit var viewModel: DestinationsListViewModel

    private val fetchDestinationsListInteractor: FetchDestinationsListInteractor = mockk()
    private val destinationMapper: Mapper<DomainDestination, Destination> = mockk()


    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = com.evaneos.common.test.utils.MainCoroutineRule()

    @Before
    fun setUp() {
        viewModel = DestinationsListViewModel(fetchDestinationsListInteractor, destinationMapper)
    }

    @Test
    fun `DestinationsListViewModel should update destinations on load call`() = runBlocking {
        val size = 10
        val destination = DestinationFixtures.getDestination()
        val expected = MutableList(size) { destination }

        coEvery { fetchDestinationsListInteractor.fetchDestinationsList() } answers { DestinationFixtures.getDomainDestinations(size) }
        coEvery { destinationMapper.invoke(any()) } answers { destination }

        viewModel.load()

        coVerify(exactly = 1) { fetchDestinationsListInteractor.fetchDestinationsList()  }
        coVerify(exactly = size) { destinationMapper.invoke(any()) }
        assertEquals(expected, viewModel.destinations.getOrAwaitValue())
    }

    @Test
    fun `DestinationsListViewModel works correctly with an empty list`() = runBlocking {
        coEvery { fetchDestinationsListInteractor.fetchDestinationsList() } answers { emptyList() }

        viewModel.load()

        coVerify(exactly = 1) { fetchDestinationsListInteractor.fetchDestinationsList()  }
        coVerify(exactly = 0) { destinationMapper.invoke(any()) }
        assertEquals(emptyList<Destination>(), viewModel.destinations.getOrAwaitValue())
    }

    @Test
    fun `DestinationsListViewModel should update route to DestinationsDetails on selectDestination call`() {
        val destination = DestinationFixtures.getDestination()

        viewModel.selectDestination(destination)
        assertEquals(
            Route.DestinationDetails(destination.id, destination.name),
            viewModel.route.getOrAwaitValue()
        )
    }
}
