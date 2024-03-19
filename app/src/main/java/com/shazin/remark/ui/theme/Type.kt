package com.shazin.remark.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.shazin.remark.R


// Product Sans font
val ProductSans = FontFamily(
    Font(R.font.ps_regular, FontWeight.Normal, FontStyle.Normal)
)
val ProductSansBold = FontFamily(
    Font(R.font.ps_bold, FontWeight.Bold, FontStyle.Normal)
)
val ProductSansBlack = FontFamily(
    Font(R.font.ps_black, FontWeight.Black, FontStyle.Normal)
)


// Custom text style
val customTextStyle =  TextStyle(fontFamily = ProductSans)

// Custom typography
val customTypography =Typography(
    bodyLarge = TextStyle.Default,
    bodyMedium = customTextStyle,
    bodySmall = customTextStyle,
    headlineLarge = customTextStyle,
    headlineMedium = customTextStyle,
    headlineSmall = customTextStyle,
    displayLarge = displayLarge,
    displayMedium = customTextStyle,
    displaySmall = customTextStyle,

)


