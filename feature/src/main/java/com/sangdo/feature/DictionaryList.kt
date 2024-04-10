package com.sangdo.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sangdo.feature.ui.theme.Pink80
import com.sangdo.repository.model.UrbanModel

@Composable
fun DictionaryList(
    list: List<UrbanModel>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(Pink80)
    ) {
        items(list) { detail ->
            detail.word
        }
    }
}

@Composable
fun DictionaryRow(
    modifier: Modifier = Modifier
) {
    Card(
        modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Text(text = "asdf")
    }
}

@Preview(showBackground = true)
@Composable
fun UrbanComposePreview() {
    DictionaryRow()
}