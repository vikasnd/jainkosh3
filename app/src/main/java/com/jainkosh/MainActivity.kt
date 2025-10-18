package com.jainkosh

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    private lateinit var menuLayout: LinearLayout
    private lateinit var webView: WebView
    private lateinit var btnMenu: Button

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuLayout = findViewById(R.id.menuLayout)
        webView = findViewById(R.id.webView)
        btnMenu = findViewById(R.id.btnMenu)

        findViewById<Button>(R.id.btnVideos).setOnClickListener {
            showWebView("https://www.jainkosh.org/wiki/Videos")
        }
        findViewById<Button>(R.id.btnAudio).setOnClickListener {
            showWebView("https://www.jainkosh.org/wiki/Audio")
        }
        findViewById<Button>(R.id.btnLiterature).setOnClickListener {
            showWebView("https://www.jainkosh.org/wiki/Granths")
        }
        findViewById<Button>(R.id.btnStudy).setOnClickListener {
            showWebView("https://www.jainkosh.org/wiki/Notes")
        }
        findViewById<Button>(R.id.btnClass).setOnClickListener {
            showWebView("https://www.jainkosh.org/wiki/Onlineclass")
        }
        btnMenu.setOnClickListener {
            webView.visibility = View.GONE
            menuLayout.visibility = View.VISIBLE
        }

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
    }

    private fun showWebView(url: String) {
        menuLayout.visibility = View.GONE
        webView.visibility = View.VISIBLE
        webView.loadUrl(url)
    }
}
