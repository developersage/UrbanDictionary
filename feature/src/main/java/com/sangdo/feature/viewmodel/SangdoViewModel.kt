package com.sangdo.feature.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class SangdoViewModel : ViewModel() {

    protected var <T> StateFlow<T>.next
        get() = value
        set(state) { (this as MutableStateFlow<T>).value = state }

    protected fun <T> mutableStateFlowOf(initialState: T) = MutableStateFlow(initialState) as StateFlow<T>
}