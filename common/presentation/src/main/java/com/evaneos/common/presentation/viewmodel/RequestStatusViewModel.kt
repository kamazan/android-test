package com.evaneos.common.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evaneos.common.presentation.mapper.ExceptionMapper
import com.evaneos.common.presentation.model.RequestStatus
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class RequestStatusViewModel: ViewModel() {
    private val exceptionMapper = ExceptionMapper()

    protected val _requestStatus = MutableLiveData<RequestStatus>(RequestStatus.Idle)
    val requestStatus: LiveData<RequestStatus> = _requestStatus

    protected val errorHandler = CoroutineExceptionHandler { _, throwable ->
        val failure = RequestStatus.Failure(exceptionMapper(throwable))
        _requestStatus.value = failure
    }

    protected fun CoroutineScope.executeRequest(block: suspend CoroutineScope.() -> Unit) {
        this.launch(errorHandler) {
            _requestStatus.value = RequestStatus.Loading
            block.invoke(this)
            _requestStatus.value = RequestStatus.Done
        }
    }
}