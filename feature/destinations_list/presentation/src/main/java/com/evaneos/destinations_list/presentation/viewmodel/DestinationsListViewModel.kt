package com.evaneos.destinations_list.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.evaneos.common.data.mapper.Mapper
import com.evaneos.common.presentation.model.Route
import com.evaneos.common.presentation.utils.SingleLiveEvent
import com.evaneos.common.presentation.viewmodel.RequestStatusViewModel
import com.evaneos.destinations_list.domain.interactor.FetchDestinationsListInteractor
import com.evaneos.destinations_list.presentation.mapper.DomainDestinationToDestinationMapper
import com.evaneos.destinations_list.domain.model.Destination as DomainDestination
import com.evaneos.destinations_list.presentation.model.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DestinationsListViewModel @Inject constructor(
    private val fetchDestinationsListInteractor: FetchDestinationsListInteractor,
    private val destinationMapper: Mapper<DomainDestination, Destination> = DomainDestinationToDestinationMapper(),
) : RequestStatusViewModel() {
    private val _destinations = MutableLiveData<List<Destination>>()
    val destinations: LiveData<List<Destination>> = _destinations

    private val _test = MutableLiveData<List<DomainDestination>>()
    val test: LiveData<List<DomainDestination>> = _test

    private val _route = SingleLiveEvent<Route>()
    val route: LiveData<Route> = _route

    fun load() {
        viewModelScope.executeRequest {
            _destinations.value = fetchDestinationsListInteractor
                .fetchDestinationsList()
                .map { destination ->
                    destinationMapper(destination)
                }
        }
    }

    fun selectDestination(destination: Destination) {
        _route.value = Route.DestinationDetails(destination.id)
    }
}