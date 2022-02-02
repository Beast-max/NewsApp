package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val navController  =Navigation.findNavController(this,R.id.activity_main_nav_host_fragment)
        val bottom_nav = findViewById<BottomNavigationView>(R.id.activity_main_bottom_navigation_view)
        NavigationUI.setupWithNavController(bottom_nav,navController)

    }
}