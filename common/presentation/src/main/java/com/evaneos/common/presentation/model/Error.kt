package com.evaneos.common.presentation.model

class Error(val type: Type, val throwable: Throwable) {
    enum class Type {
        UNKNOWN
    }
}