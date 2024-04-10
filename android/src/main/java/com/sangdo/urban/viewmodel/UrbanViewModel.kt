package com.sangdo.urban.viewmodel

import androidx.lifecycle.viewModelScope
import com.sangdo.repository.UrbanRepository
import com.sangdo.repository.model.UrbanModel
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
    val data = mutableStateFlowOf<List<UrbanModel>>(emptyList())

    fun search(word: String) {
        repository.getDefinition(word)
            .onStart { isLoading.next = true }
            .onEach { list -> data.next = list }
            .onCompletion { isLoading.next = false }
            .launchIn(viewModelScope)
    }

}