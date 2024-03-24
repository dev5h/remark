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
    val alpha = (argb shr 24) and 0xFF
    val red = (argb shr 16) and 0xFF
    val green = (argb shr 8) and 0xFF
    val blue = argb and 0xFF
    return "rgba($red, $green, $blue, ${alpha.toFloat() / 255})"
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


fun getAssetString(context: Context, file_path:String): String{
    val input = context.assets.open(file_path)
    val bufferedReader = BufferedReader(InputStreamReader(input))
    val stringBuilder = StringBuilder()
    var line: String?
    while (bufferedReader.readLine().also { line = it } != null) {
        stringBuilder.append(line)
    }
    return  stringBuilder.toString()
}
fun escapeSpecialCharacters(input: String): String {
    return input.replace("[`\\\\\\{}]".toRegex(), "\\\\$0")
}