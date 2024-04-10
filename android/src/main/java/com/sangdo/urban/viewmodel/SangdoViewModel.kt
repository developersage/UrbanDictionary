package com.sangdo.urban.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class SangdoViewModel : ViewModel() {

    var <T> StateFlow<T>.next
        get() = this.value
        set(state) { (this as MutableStateFlow<T>).value = state }

    fun <T> mutableStateFlowOf(initialState: T) = MutableStateFlow(initialState).asStateFlow()

}