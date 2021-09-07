package com.evaneos.destinations_list.presentation.ui

import androidx.lifecycle.LifecycleOwner
import com.evaneos.common.presentation.model.RequestStatus
import com.evaneos.destinations_list.databinding.FragmentDestinationsListBinding
import com.evaneos.destinations_list.presentation.viewmodel.DestinationsListViewModel

class DestinationsListViewHolder(
    binding: FragmentDestinationsListBinding,
    lifecycleOwner: LifecycleOwner,
    private val viewModel: DestinationsListViewModel
) {
    init {
        with(viewModel) {
            requestStatus.observe(lifecycleOwner) {
                binding.destinationsListSwipeLayout.isRefreshing = it is RequestStatus.Loading
            }
            binding.destinationsListSwipeLayout.setOnRefreshListener { viewModel.load() }
        }
    }
}
