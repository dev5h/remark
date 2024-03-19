package com.shazin.remark

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

fun getRGB(color: Color): String{
    val argb = color.toArgb()
    val red = (argb shr 16) and 0xFF
    val green = (argb shr 8) and 0xFF
    val blue = argb and 0xFF
    return "rgb($red, $green, $blue)"
}




@Composable
fun getPreviewTemplate(context: Context): String{
    val input = context.assets.open("html/index.html")
    val bufferedReader = BufferedReader(InputStreamReader(input))
    val stringBuilder = StringBuilder()
    var line: String?
    while (bufferedReader.readLine().also { line = it } != null) {
        stringBuilder.append(line)
    }
    var string  = stringBuilder.toString()
    val m3c  = MaterialTheme.colorScheme
    string  = string.replace("bgColor", getRGB( m3c.background))
    string  = string.replace("fgColor", getRGB( m3c.onBackground))
    return string
}