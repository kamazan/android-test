package com.evaneos.destinations_list.ui

import androidx.fragment.app.Fragment
import com.evaneos.destinations_list.R
import com.evaneos.destinations_list.navigation.DestinationsListActions
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DestinationsListFragment: Fragment(R.layout.fragment_destinations_list) {
    @Inject
    lateinit var destinationsListActions: DestinationsListActions
}