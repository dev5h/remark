package com.shazin.remark

import android.graphics.Bitmap
import android.graphics.Color
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class MyWebViewClient(
    val fg: String
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
        // You can perform actions here, such as hiding a loading indicator.
        super.onPageFinished(view, url)
    }
}