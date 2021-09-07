package com.evaneos.destinations_list.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.evaneos.common.presentation.model.RequestStatus
import com.evaneos.common.presentation.model.Route
import com.evaneos.common.presentation.utils.SingleLiveEvent
import com.evaneos.common.presentation.viewmodel.RequestStatusViewModel
import com.evaneos.destinations_list.domain.interactor.FetchDestinationsListInteractor
import com.evaneos.destinations_list.domain.model.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DestinationsListViewModel @Inject constructor(
    private val fetchDestinationsListInteractor: FetchDestinationsListInteractor,
): RequestStatusViewModel() {
    private val _destinations = MutableLiveData<List<Destination>>()
    val destinations: LiveData<List<Destination>> = _destinations

    private val _route = SingleLiveEvent<Route>()
    val route: LiveData<Route> = _route
    
    fun load() {
        viewModelScope.executeRequest {
            _destinations.value = fetchDestinationsListInteractor.fetchDestinationsList()
        }
    }

    fun selectDestination(destination: Destination) {
        _route.value = Route.DestinationDetails(destination.id)
    }
}