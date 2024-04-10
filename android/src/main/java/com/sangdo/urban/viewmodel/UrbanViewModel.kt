package com.sangdo.urban.viewmodel

import androidx.lifecycle.viewModelScope
import com.sangdo.network.module.UrbanModel
import com.sangdo.urban.repository.UrbanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class UrbanViewModel @Inject constructor(
    private val repository: UrbanRepository
) : SangdoViewModel() {
    val isLoading = mutableStateFlowOf(false)
    val data = mutableStateFlowOf<UrbanModel?>(null)

    fun search(word: String) {
        repository.getDefinition(word)
            .onStart { isLoading.next = true }
            .onEach { model ->
                data.next = model
            }
            .onCompletion { isLoading.next = false }
            .launchIn(viewModelScope)
    }

}