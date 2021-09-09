package com.evaneos.destination_details.presentation.viewmodel

import android.os.Bundle
import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner
import com.evaneos.common.presentation.viewmodel.RequestStatusViewModel
import com.evaneos.destination_details.domain.interactor.FetchDestinationDetailsInteractor
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class DestinationDetailsViewModel @AssistedInject constructor(
    @Assisted private val destinationId: Long,
    private val fetchDestinationDetailsInteractor: FetchDestinationDetailsInteractor,
) : RequestStatusViewModel() {
    private val _destinationUrlPage = MutableLiveData<String>()
    val destinationUrlPage: LiveData<String> = _destinationUrlPage

    init {
        load()
    }

    fun load() {
        viewModelScope.executeRequest {
            _destinationUrlPage.value = fetchDestinationDetailsInteractor.fetchDestinationDetails(destinationId).url
        }
    }

    @AssistedFactory
    interface DestinationDetailsViewModelFactory {
        fun create(destinationId: Long): DestinationDetailsViewModel
    }

    companion object {
        fun provideFactory(
            assistedFactory: DestinationDetailsViewModelFactory,
            owner: SavedStateRegistryOwner,
            defaultArgs: Bundle? = null,
            destinationId: Long,
        ) = object : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(
                key: String,
                modelClass: Class<T>,
                handle: SavedStateHandle
            ): T {
                return assistedFactory.create(destinationId) as T
            }
        }
    }
}