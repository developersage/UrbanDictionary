package com.sangdo.feature.viewmodel

import androidx.lifecycle.viewModelScope
import com.google.android.gms.ads.AdRequest
import com.sangdo.feature.di.AdUnitId
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
    private val repository: UrbanRepository,
    @AdUnitId adUnitId: String,
    adRequest: AdRequest
) : SangdoViewModel() {
    val isLoading = mutableStateFlowOf(false)
    val adState = mutableStateFlowOf<AdParams>(AdParams.Loading)
    val definitionList = mutableStateFlowOf<List<UrbanModel>>(emptyList())

    init {
        adState.next = AdParams.Ready(adUnitId, adRequest)
    }

    fun search(word: String) {
        repository.getDefinition(word)
            .flowOn(Dispatchers.IO)
            .onStart { isLoading.next = true }
            .onEach { list -> definitionList.next = list }
            .catch { error -> error.printStackTrace() }
            .onCompletion { isLoading.next = false }
            .launchIn(viewModelScope)
    }

    sealed interface AdParams {
        data object Loading : AdParams
        data class Ready(
            val adUnitId: String,
            val adRequest: AdRequest
        ) : AdParams
    }
}