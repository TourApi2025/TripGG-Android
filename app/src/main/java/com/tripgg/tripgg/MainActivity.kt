package com.tripgg.tripgg

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)

        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true

        webView.loadUrl("https://trip-gg-front.vercel.app/")

        window.statusBarColor = ContextCompat.getColor(this, R.color.white) // 원하는 색
        WindowInsetsControllerCompat(window, window.decorView)
            .isAppearanceLightStatusBars = true

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // 웹뷰에서 뒤로 갈 페이지가 있으면 이전 페이지로 이동
                if (webView.canGoBack()) {
                    webView.goBack()
                } else {
                    // 더 이상 뒤로 갈 페이지가 없으면 액티비티 종료
                    finish()
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)
    }
}
