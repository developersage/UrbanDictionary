package com.sangdo.feature

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun AdBanner(
    adRequest: AdRequest,
    context: Context = LocalContext.current,
    modifier: Modifier = Modifier,
) {
    AndroidView(
        modifier = modifier,
        factory = {
            AdView(context).apply {
                adUnitId = "ca-app-pub-3926306702817572~3394052504"
                setAdSize(AdSize.BANNER)
                loadAd(adRequest)
            }
        }
    )
}