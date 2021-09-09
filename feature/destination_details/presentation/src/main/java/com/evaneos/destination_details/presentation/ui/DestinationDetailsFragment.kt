package com.evaneos.destination_details.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.evaneos.common.presentation.ui.SnackbarViewHolder
import com.evaneos.destination_details.presentation.databinding.FragmentDestinationDetailsBinding
import com.evaneos.destination_details.presentation.viewmodel.DestinationDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DestinationDetailsFragment : Fragment() {
    private val navArgs by navArgs<DestinationDetailsFragmentArgs>()

    private lateinit var binding: FragmentDestinationDetailsBinding

    @Inject
    lateinit var viewModelFactory: DestinationDetailsViewModel.DestinationDetailsViewModelFactory
    private val viewModel: DestinationDetailsViewModel by viewModels {
        DestinationDetailsViewModel.provideFactory(
            viewModelFactory,
            this,
            arguments,
            navArgs.destinationId
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDestinationDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        activity?.title = navArgs.destinationName
        with(viewModel) {
            DestinationDetailsViewHolder(binding, viewLifecycleOwner, viewModel)
            SnackbarViewHolder(binding.root, viewLifecycleOwner, requestStatus, ::load)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressed)
    }

    private val onBackPressed = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (binding.destinationDetailsWebView.canGoBack()) {
                binding.destinationDetailsWebView.goBack()
            } else {
                findNavController().popBackStack()
            }
        }
    }
}