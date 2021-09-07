package com.evaneos.common.presentation.ui

import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.*
import com.evaneos.common.presentation.R
import com.evaneos.common.presentation.mapper.ErrorToTextMapper
import com.evaneos.common.presentation.model.Error
import com.evaneos.common.presentation.model.RequestStatus
import com.google.android.material.snackbar.Snackbar

class SnackbarViewHolder(
    val coordinatorLayout: CoordinatorLayout,
    lifecycleOwner: LifecycleOwner,
    state: LiveData<RequestStatus>,
    private val retry: (() -> Unit)? = null
): LifecycleObserver {
    private val errorToTextMapper = ErrorToTextMapper()
    var snackBar: Snackbar? = null

    init {
        state.observe(lifecycleOwner, ::onStateChanged)
        lifecycleOwner.lifecycle.addObserver(this)
    }

    private fun onStateChanged(state: RequestStatus) {
        when (state) {
            is RequestStatus.Failure -> displayErrorMessage(state.error)
            else -> dismiss()
        }
    }

    private fun displayErrorMessage(error: Error) {
        val message = errorToTextMapper(error).let { coordinatorLayout.context.getString(it) }
        show(coordinatorLayout, message, Snackbar.LENGTH_INDEFINITE, retry)
    }

    private fun show(view: View, message: CharSequence, duration: Int, retry: (() -> Unit)?) {
        snackBar = Snackbar.make(view, message, duration).apply {
            retry?.let { setAction(R.string.retry) { it() } }
            show()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun dismiss() {
        snackBar?.dismiss()
    }
}