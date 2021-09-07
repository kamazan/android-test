package com.evaneos.common.presentation.ui

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.evaneos.common.presentation.R
import com.google.android.material.snackbar.Snackbar

internal class SnackBarHolder : LifecycleObserver {
    var snackBar: Snackbar? = null

    fun show(view: View, message: CharSequence, duration: Int, retry: (() -> Unit)?) {
        snackBar = Snackbar.make(view, message, duration).apply {
            retry?.let { setAction(R.string.retry) { it() } }
            show()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun dismiss() {
        snackBar?.dismiss()
    }
}