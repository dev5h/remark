package com.shazin.remark

import android.content.Context
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
    val colorScheme: ColorScheme,
    val context: Context,
    val inputText: String
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
                .hjljs-container {
                background: ${getRGB(colorScheme.surfaceVariant.copy(alpha = 0.3f))};
                color: ${getRGB(colorScheme.onSurfaceVariant)};
                }
                p code {
                background: ${getRGB(colorScheme.surfaceVariant.copy(alpha = 0.3f))};
                color: ${getRGB(colorScheme.onSurfaceVariant)}
                }
            `;
            document.head.appendChild(styleTag);
        """.trimIndent()
        view?.evaluateJavascript(injectionJS,null)
        val contentInjectionUpper = getAssetString(context = context, file_path = "raw/js_upper.txt")
        val contentInjection = """
            const test = 
             `${escapeSpecialCharacters(inputText)}`
              ;
            container.innerHTML = md.render(test);
            renderMathInElement(container, {
        delimiters: [
        { left: "${'$'}${'$'}", right: "${'$'}${'$'}", display: true },
        { left: "${'$'}", right: "${'$'}", display: false },
        { left: "\\(", right: "\\)", display: false },
        { left: "\\[", right: "\\]", display: true },
        ],
        throwOnError: false,
        })
            
            console.log(container.innerHTML)
        """.trimIndent()
        val contentInjectionLower = getAssetString(context = context, file_path = "raw/js_lower.txt")
        println("Injecting $contentInjection")
        view?.evaluateJavascript(  contentInjection ,null)
        onLoad()
        super.onPageFinished(view, url)
    }
}