package com.sangdo.urban.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class SangdoViewModel : ViewModel() {

    var <T> StateFlow<T>.next
        get() = this.value
        set(state) { (this as MutableStateFlow<T>).value = state }

    fun <T> mutableStateFlowOf(initialState: T): StateFlow<T> = MutableStateFlow(initialState)

}