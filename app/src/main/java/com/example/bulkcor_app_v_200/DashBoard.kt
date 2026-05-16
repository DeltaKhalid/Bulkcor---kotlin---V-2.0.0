package com.example.bulkcor_app_v_200

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
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
    }
}