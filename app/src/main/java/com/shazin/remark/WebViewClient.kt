package com.shazin.remark

import android.graphics.Bitmap
import android.graphics.Color
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.MutableState

class MyWebViewClient(
    val fg: String,
    val onLoad: ()->Unit,
    val isSystemInDarkTheme: Boolean,
    val colorScheme: ColorScheme
) : WebViewClient() {
    override fun shouldOverrideUrlLoading(
        view: WebView?,
        request: WebResourceRequest?
    ): Boolean {
        // This method is called when a new URL is about to be loaded in the WebView.
        // You can perform actions here, such as displaying a loading indicator.
        return super.shouldOverrideUrlLoading(view, request)
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        // This method is called when the WebView starts to load a new page.
        // You can perform actions here, such as displaying a loading indicator.
        super.onPageStarted(view, url, favicon)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        // This method is called when the WebView finishes loading a page.
        if (view != null) {
            view.evaluateJavascript("document.body.style.color = '${fg}'",null)
        }

        val css = """
            
        """.trimIndent()
        val injectionJS= """
            var styleTag = document.createElement('style');
            styleTag.innerHTML = `
                pre {
                background: ${getRGB(colorScheme.surfaceVariant.copy(alpha = 0f))}
            }
            `;
            document.head.appendChild(styleTag);
        """.trimIndent()
        view?.evaluateJavascript(injectionJS,null)
        onLoad()
        super.onPageFinished(view, url)
    }
}