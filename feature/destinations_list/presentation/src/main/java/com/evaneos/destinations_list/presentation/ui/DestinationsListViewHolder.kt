package com.evaneos.destinations_list.presentation.ui

import androidx.lifecycle.LifecycleOwner
import com.evaneos.common.presentation.model.RequestStatus
import com.evaneos.common.presentation.ui.recyclerview.decoration.MarginItemDecoration
import com.evaneos.destinations_list.R
import com.evaneos.destinations_list.databinding.FragmentDestinationsListBinding
import com.evaneos.destinations_list.presentation.mapper.DestinationItemsMapper
import com.evaneos.destinations_list.presentation.model.Destination
import com.evaneos.destinations_list.presentation.model.DestinationItem
import com.evaneos.destinations_list.presentation.ui.recyclerview.DestinationAdapter
import com.evaneos.destinations_list.presentation.viewmodel.DestinationsListViewModel

class DestinationsListViewHolder(
    private val binding: FragmentDestinationsListBinding,
    lifecycleOwner: LifecycleOwner,
    private val viewModel: DestinationsListViewModel
) {
    private val itemsMapper = DestinationItemsMapper()

    private val destinationAdapter = DestinationAdapter { _, item ->
        when (item) {
            is DestinationItem.DestinationCardItem -> viewModel.selectDestination(item.destination)
            DestinationItem.DestinationEmptyMessageItem -> viewModel.load()
        }
    }

    init {
        with(viewModel) {
            requestStatus.observe(lifecycleOwner) { status ->
                binding.destinationsListSwipeLayout.isRefreshing = status is RequestStatus.Loading
            }
            binding.destinationsListSwipeLayout.setOnRefreshListener { viewModel.load() }
            destinations.observe(lifecycleOwner, ::onDestinations)
        }

        setUpRecyclerView()
    }

    private fun onDestinations(destinations: List<Destination>) {
        destinationAdapter.submitList(itemsMapper(destinations))
    }

    private fun setUpRecyclerView() {
        with(binding.destinationsListRecyclerView) {
            adapter = destinationAdapter
            addItemDecoration(
                MarginItemDecoration(
                    resources,
                    height = R.dimen.destinations_list_vertical_margin,
                    width = R.dimen.destinations_list_horizontal_margin,
                ),
            )
        }
    }
}
