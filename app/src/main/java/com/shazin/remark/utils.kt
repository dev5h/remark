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

@RequiresApi(Build.VERSION_CODES.O)
fun getColorHex(color: Color): String {
    val argb = color.toArgb()
    return String.format("#%08X", argb)
}

fun replaceToken(source: String, token: String, replacement: String): String {
    return source.replace(token, replacement)
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun getPreviewTemplate(context: Context){
    val input = context.assets.open("html/index.html")
    val bufferedReader = BufferedReader(InputStreamReader(input))
    val stringBuilder = StringBuilder()
    var line: String?
    while (bufferedReader.readLine().also { line = it } != null) {
        stringBuilder.append(line)
    }
    var string  = stringBuilder.toString()
    string  = string.replace("bgColor", getColorHex(MaterialTheme.colorScheme.background))
    println(string)
}