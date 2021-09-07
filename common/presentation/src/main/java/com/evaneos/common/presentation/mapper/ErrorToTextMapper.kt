package com.evaneos.common.presentation.mapper

import com.evaneos.common.presentation.R
import com.evaneos.common.presentation.model.Error

class ErrorToTextMapper: (Error) -> @androidx.annotation.StringRes Int {
    override fun invoke(error: Error): Int {
        return when (error.type) {
            Error.Type.UNKNOWN -> R.string.error_unknown
        }
    }
}