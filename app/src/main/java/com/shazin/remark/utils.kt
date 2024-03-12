package com.shazin.remark

import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

fun readHTMLFromRaw(context: Context, rawResourceId: Int): String {
    return try {
        val inputStream: InputStream = context.resources.openRawResource(rawResourceId)
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        var line: String? = null
        while (bufferedReader.readLine().also { line = it } != null) {
            stringBuilder.append(line)
        }
        stringBuilder.toString()
    } catch (ioException: IOException) {
        ""
    }
}