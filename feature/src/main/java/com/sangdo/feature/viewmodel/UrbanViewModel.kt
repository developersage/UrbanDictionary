package com.sangdo.feature.viewmodel

import androidx.lifecycle.viewModelScope
import com.sangdo.repository.UrbanRepository
import com.sangdo.repository.model.UrbanModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
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
    val definitionList = mutableStateFlowOf<List<UrbanModel>>(emptyList())

    fun search(word: String) {
        repository.getDefinition(word)
            .flowOn(Dispatchers.IO)
            .onStart { isLoading.next = true }
            .onEach { list -> definitionList.next = list }
            .catch { error -> error.printStackTrace() }
            .onCompletion { isLoading.next = false }
            .launchIn(viewModelScope)
    }
}