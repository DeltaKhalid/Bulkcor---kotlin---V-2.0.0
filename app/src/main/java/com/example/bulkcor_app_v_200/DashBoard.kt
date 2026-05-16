package com.example.bulkcor_app_v_200

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.animation.ObjectAnimator
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DashBoard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.dashboardToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // Toggle drawer when left menu icon is tapped (open if closed, close if open)
        val drawer = findViewById<DrawerLayout?>(R.id.drawer_layout)
        val ivMenu = findViewById<ImageView?>(R.id.ivMenu)
        ivMenu?.setOnClickListener {
            drawer?.let { d ->
                if (d.isDrawerOpen(GravityCompat.START)) d.closeDrawer(GravityCompat.START)
                else d.openDrawer(GravityCompat.START)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Bottom navigation: wire clicks and active state
        val navHome = findViewById<LinearLayout?>(R.id.navHome)
        val navAch = findViewById<LinearLayout?>(R.id.navAch)
        val navReport = findViewById<LinearLayout?>(R.id.navReport)
        val navKnow = findViewById<LinearLayout?>(R.id.navKnow)

        val iconHome = findViewById<ImageView?>(R.id.iconHome)
        val iconAch = findViewById<ImageView?>(R.id.iconAch)
        val iconReport = findViewById<ImageView?>(R.id.iconReport)
        val iconKnow = findViewById<ImageView?>(R.id.iconKnow)

        val underlineHome = findViewById<View?>(R.id.underlineHome)
        val underlineAch = findViewById<View?>(R.id.underlineAch)
        val underlineReport = findViewById<View?>(R.id.underlineReport)
        val underlineKnow = findViewById<View?>(R.id.underlineKnow)

        fun animateUnderline(line: View?) {
            line?.apply {
                alpha = 0f
                visibility = View.VISIBLE
                val fadeIn = ObjectAnimator.ofFloat(this, View.ALPHA, 0f, 1f)
                fadeIn.duration = 220
                fadeIn.start()
            }
        }

        fun setActive(id: Int) {
            listOf(underlineHome, underlineAch, underlineReport, underlineKnow).forEach { line ->
                if (line?.visibility == View.VISIBLE) {
                    val fadeOut = ObjectAnimator.ofFloat(line, View.ALPHA, 1f, 0f)
                    fadeOut.duration = 200
                    fadeOut.start()
                    line.visibility = View.GONE
                }
            }
            listOf(iconHome, iconAch, iconReport, iconKnow).forEach { icon ->
                icon?.isSelected = false
            }

            when (id) {
                R.id.navHome -> {
                    animateUnderline(underlineHome)
                    iconHome?.isSelected = true
                }
                R.id.navAch -> {
                    animateUnderline(underlineAch)
                    iconAch?.isSelected = true
                }
                R.id.navReport -> {
                    animateUnderline(underlineReport)
                    iconReport?.isSelected = true
                }
                R.id.navKnow -> {
                    animateUnderline(underlineKnow)
                    iconKnow?.isSelected = true
                }
            }
        }

        // Wire click listeners
        navHome?.setOnClickListener {
            setActive(R.id.navHome)
            Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
        }
        navAch?.setOnClickListener {
            setActive(R.id.navAch)
            Toast.makeText(this, "Achievement clicked", Toast.LENGTH_SHORT).show()
        }
        navReport?.setOnClickListener {
            setActive(R.id.navReport)
            Toast.makeText(this, "Report clicked", Toast.LENGTH_SHORT).show()
        }
        navKnow?.setOnClickListener {
            setActive(R.id.navKnow)
            Toast.makeText(this, "Knowledge clicked", Toast.LENGTH_SHORT).show()
        }

        // Default select Home
        setActive(R.id.navHome)
    }
}