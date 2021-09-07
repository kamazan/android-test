package com.evaneos.common.presentation.model

sealed class RequestStatus {
    object Idle: RequestStatus()
    object Loading: RequestStatus()
    object Done: RequestStatus()
    class Failure(val error: Error): RequestStatus()
}