package com.sangdo.feature

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sangdo.feature.ui.theme.Purple40
import com.sangdo.feature.ui.theme.Purple80
import com.sangdo.feature.ui.theme.PurpleGrey80
import com.sangdo.repository.model.UrbanModel

@Composable
fun DictionaryList(
    list: List<UrbanModel>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(PurpleGrey80)
    ) {
        items(list) { detail ->
            DictionaryRow(item = detail)
        }
    }
}

@Composable
fun DictionaryRow(
    item: UrbanModel,
    modifier: Modifier = Modifier
) = with(item) {
    Card(
        border = BorderStroke(2.dp, Purple40),
        colors = CardColors(Purple80, Purple40, Color.LightGray, Color.Gray),
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(vertical = 5.dp, horizontal = 10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier.padding(10.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(10.dp)
            ) {
                Text(text = word)
                Text(text = author)
                Spacer(modifier = modifier.weight(1f))
                Text(text = thumbsUp)
                Text(text = thumbsDown)
            }
            Text(text = definition, overflow = TextOverflow.Clip)
            Text(text = example, overflow = TextOverflow.Clip)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UrbanComposePreview() {
    DictionaryRow(
        UrbanModel(
            "wat",
            "watwat",
            "The only [proper] [response] to something that makes absolutely [no sense].",
            "1: If all the animals on the [equator] were capable of [flattery], Halloween and Easter would fall on the same day.\\r\\n2: wat\\r\\n\\r\\n1: Wow your cock is almost as big as my dad's.\\r\\n2: wat\\r\\n\\r\\n1: I accidentially a whole [coke bottle]\\r\\n2: You accidentially what?\\r\\n1: A whole coke bottle\\r\\n2: wat",
            "3995",
            "443"
        )
    )
}