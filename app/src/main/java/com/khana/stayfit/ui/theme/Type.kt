package com.khana.stayfit.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.khana.stayfit.R

// Set of Material typography styles to start with
val Typography = Typography(
    titleSmall = TextStyle(
        fontFamily = AppFont.fontFamily,
        fontWeight = FontWeight.Bold
    ),
    titleLarge = TextStyle(
        fontFamily = AppFont.fontFamily,
        fontWeight = FontWeight.Normal
    )

)

object AppFont {
    val bold = Font(R.font.bold, weight = FontWeight.Bold)
    val light = Font(R.font.light, weight = FontWeight.Light)
    val semibold = Font(R.font.semibold, weight = FontWeight.SemiBold)
    val medium = Font(R.font.medium, weight = FontWeight.Medium)
    val regular = Font(R.font.regular, weight = FontWeight.Normal)
    val fontFamily = FontFamily(
        bold, light, semibold, medium, regular
    )
}