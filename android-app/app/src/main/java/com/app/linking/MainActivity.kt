package com.app.linking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Main Activity"

        // ATTENTION: This was auto-generated to handle app links.
        val appLinkIntent: Intent = intent
        val appLinkAction: String? = appLinkIntent.action
        val appLinkData: Uri? = appLinkIntent.data

        val textView = findViewById<TextView>(R.id.text_view)

        Log.d(TAG, "onCreate: appLinkAction: $appLinkAction \nappLinkData: $appLinkData")
        if (Intent.ACTION_VIEW == appLinkAction) {
            textView.text = appLinkData?.getQueryParameter("inputData");
            Log.d(TAG, "onCreate: Query: ${appLinkData?.query}")
        }

    }
}