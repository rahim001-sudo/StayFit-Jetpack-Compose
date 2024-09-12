package com.khana.stayfit.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class OnboardingPage(
    val background: Color,
    val title: String,
    val stepNumber: Int,
    @DrawableRes val image: Int
)