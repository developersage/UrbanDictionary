package com.sangdo.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sangdo.feature.viewmodel.UrbanViewModel

@Composable
fun MainScreen(
    viewModel: UrbanViewModel = viewModel()
) {
    val list by viewModel.definitionList.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val adState by viewModel.adState.collectAsState()

    Scaffold(
        topBar = { SearchBar(onSearch = viewModel::search) },
        bottomBar = {
            (adState as? UrbanViewModel.AdParams.Ready)
                ?.let { (id, request) -> AdBanner(id = id, adRequest = request) }
        },
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) { bottomPadding ->
        DictionaryList(list = list, modifier = Modifier.padding(bottomPadding))
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) CircularProgressIndicator()
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}