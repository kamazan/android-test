package com.evaneos.destination_details.presentation.ui

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import com.evaneos.common.presentation.model.RequestStatus
import com.evaneos.destination_details.presentation.databinding.FragmentDestinationDetailsBinding
import com.evaneos.destination_details.presentation.viewmodel.DestinationDetailsViewModel


@SuppressLint("SetJavaScriptEnabled")
class DestinationDetailsViewHolder(
    private val binding: FragmentDestinationDetailsBinding,
    lifecycleOwner: LifecycleOwner,
    viewModel: DestinationDetailsViewModel
) {
    init {
        with(viewModel) {
            destinationUrlPage.observe(lifecycleOwner, ::onUrlPageLoaded)
            requestStatus.observe(lifecycleOwner, ::onStatus)
        }

        with(binding.destinationDetailsWebView) {
            webViewClient = DestinationDetailsWebClient()
            webChromeClient = DestinationDetailsWebChromeClient()
            settings.apply {
                javaScriptEnabled = true
                loadWithOverviewMode = true
                setSupportZoom(true)
            }
        }
    }

    private fun onStatus(requestStatus: RequestStatus) {
        binding.destinationDetailsProgressBar.isVisible = requestStatus is RequestStatus.Loading
    }

    private fun onUrlPageLoaded(url: String) {
        binding.destinationDetailsWebView.loadUrl(url)
    }

    inner class DestinationDetailsWebChromeClient : WebChromeClient() {
        override fun onProgressChanged(view: WebView, newProgress: Int) {
            binding.destinationDetailsWebProgressBar.progress = newProgress
        }
    }

    inner class DestinationDetailsWebClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            binding.destinationDetailsWebProgressBar.isVisible = false
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            binding.destinationDetailsWebProgressBar.isVisible = true
        }
    }
}
