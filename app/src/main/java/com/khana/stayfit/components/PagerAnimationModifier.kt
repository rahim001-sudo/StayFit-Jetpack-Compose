package com.khana.stayfit.components

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import kotlin.math.absoluteValue

/**
 * Create custom modifiers:
 * https://developer.android.com/jetpack/compose/custom-modifiers
 */
@OptIn(ExperimentalFoundationApi::class)
fun Modifier.pagerAnimation(
    pagerState: PagerState,
    thisPageIndex: Int,
): Modifier {
    val pageOffset =
        (pagerState.currentPage - thisPageIndex) + pagerState.currentPageOffsetFraction

    return this then Modifier.graphicsLayer {
            alpha =
                lerp(
                    start = 0.4f,
                    stop = 1f,
                    fraction = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f),
                )

            cameraDistance = (8 * density).toFloat()

        translationX = pageOffset * -20.dp.toPx()

        lerp(
            start = 0.8f,
            stop = 1f,
            fraction = 1f-pageOffset.absoluteValue.coerceIn(.0f, 1f),
        ).also { scale ->
            scaleX = scale
            scaleY = scale
        }
    }
}
