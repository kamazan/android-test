package com.evaneos.common.presentation.utils.extension

import android.view.View
import android.widget.TextView

fun TextView.textOrInvisible(text: String?) {
    if (text == null) {
        visibility = View.INVISIBLE
    } else {
        visibility = View.VISIBLE
        this.text = text
    }
}