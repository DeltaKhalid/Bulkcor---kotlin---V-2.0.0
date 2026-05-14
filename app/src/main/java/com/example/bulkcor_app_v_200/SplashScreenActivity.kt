package com.example.bulkcor_app_v_200

import android.annotation.SuppressLint
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val versionText = findViewById<TextView>(R.id.versionText)
        @Suppress("DEPRECATION")
        val versionName = packageManager.getPackageInfo(packageName, 0).versionName
        versionText.text = versionName ?: ""

        val loadingIndicator = findViewById<ImageView>(R.id.loadingIndicator)
        ObjectAnimator.ofFloat(loadingIndicator, "rotation", 0f, 360f).apply {
            duration = 900L
            repeatCount = ObjectAnimator.INFINITE
            interpolator = LinearInterpolator()
            start()
        }

        // Keep the splash brief so launch feels responsive.
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 1800)
    }
}

