package com.evaneos.common.presentation.mapper

import com.evaneos.common.presentation.model.Error

class ExceptionMapper : (Throwable) -> Error {
    override fun invoke(exception: Throwable): Error {
        val type = when (exception) {
            else -> Error.Type.UNKNOWN
        }

        return Error(type = type, exception)
    }
}