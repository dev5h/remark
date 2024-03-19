package com.shazin.remark

import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

fun getPreviewTemplate(context: Context){
    val input = context.assets.open("html/index.html")
    val bufferedReader = BufferedReader(InputStreamReader(input))
    val stringBuilder = StringBuilder()
    var line: String?
    while (bufferedReader.readLine().also { line = it } != null) {
        stringBuilder.append(line)
    }
    println(stringBuilder)
}