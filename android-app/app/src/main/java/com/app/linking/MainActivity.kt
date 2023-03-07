package com.app.linking

import android.R.id.button1
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout


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

        val tilUserName = findViewById<TextInputLayout>(R.id.tilUserName)
        val tilPassword = findViewById<TextInputLayout>(R.id.tilPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            if (tilUserName.editText?.text.isNullOrEmpty()) {
                Toast.makeText(this, "Please enter user name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (tilPassword.editText?.text.isNullOrEmpty()) {
                Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                Toast.makeText(
                    this,
                    "Login Successful \nuserName: ${tilUserName.editText?.text}\npassword: ${tilPassword.editText?.text}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        Log.d(TAG, "onCreate: appLinkAction: $appLinkAction \nappLinkData: $appLinkData")
        if (Intent.ACTION_VIEW == appLinkAction) {
//            textView.text = appLinkData?.getQueryParameter("inputData");
//            Log.d(TAG, "onCreate: Query: ${appLinkData?.query}")

            val userName = appLinkData?.getQueryParameter("username")
            val password = appLinkData?.getQueryParameter("password")

            tilUserName.editText?.setText(userName ?: "")
            tilPassword.editText?.setText(password ?: "")
            if (!userName.isNullOrEmpty() && !password.isNullOrEmpty()) {
                btnLogin.performClick()
            }
        }

    }
}