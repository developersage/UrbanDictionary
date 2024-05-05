package com.sangdo.feature

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
@SuppressLint("MissingPermission")
fun AdBanner(
    id: String,
    adRequest: AdRequest,
    modifier: Modifier = Modifier,
) {
    AndroidView(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        factory = { context ->
            AdView(context).apply {
                adUnitId = id // "ca-app-pub-3940256099942544/9214589741"
                setAdSize(AdSize.BANNER)
                loadAd(adRequest)
            }
        }
    )
}

@Preview
@Composable
fun AdBannerPreview() {
    AdBanner(
        id = "ca-app-pub-3940256099942544/9214589741",
        adRequest = AdRequest.Builder().build()
    )
}

