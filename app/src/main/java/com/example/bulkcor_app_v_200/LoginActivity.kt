package com.example.bulkcor_app_v_200

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSignIn: Button
    private lateinit var tvForgotPassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Make the layout edge-to-edge / full screen friendly
        WindowCompat.setDecorFitsSystemWindows(window, true)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnSignIn = findViewById(R.id.btnSignIn)
        tvForgotPassword = findViewById(R.id.tvForgotPassword)

        btnSignIn.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()
            if (username.isEmpty()) {
                etUsername.error = "Please enter username"
                etUsername.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                etPassword.error = "Please enter password"
                etPassword.requestFocus()
                return@setOnClickListener
            }
            // TODO: implement authentication logic
            Toast.makeText(this, "Signing in…", Toast.LENGTH_SHORT).show()
        }

        tvForgotPassword.setOnClickListener {
            // TODO: implement forgot password flow
            Toast.makeText(this, "Forgot password tapped", Toast.LENGTH_SHORT).show()
        }
    }
}
