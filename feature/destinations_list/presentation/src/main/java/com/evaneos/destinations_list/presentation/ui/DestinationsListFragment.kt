package com.evaneos.destinations_list.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.evaneos.common.presentation.model.Route
import com.evaneos.common.presentation.ui.SnackbarViewHolder
import com.evaneos.destinations_list.R
import com.evaneos.destinations_list.databinding.FragmentDestinationsListBinding
import com.evaneos.destinations_list.presentation.navigation.DestinationsListActions
import com.evaneos.destinations_list.presentation.viewmodel.DestinationsListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DestinationsListFragment : Fragment() {
    @Inject
    lateinit var destinationsListActions: DestinationsListActions

    private val viewModel by viewModels<DestinationsListViewModel>()
    private lateinit var binding: FragmentDestinationsListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDestinationsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.load()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        activity?.setTitle(R.string.destination_list_title)
        with(viewModel) {
            DestinationsListViewHolder(binding, viewLifecycleOwner, viewModel)
            SnackbarViewHolder(binding.root, viewLifecycleOwner, requestStatus, ::load)
            route.observe(viewLifecycleOwner, ::onRoute)
        }
    }

    private fun onRoute(route: Route) {
        when (route) {
            is Route.DestinationDetails -> destinationsListActions.navigateToDestinationDetails(
                route.destinationId
            )
        }
    }
}