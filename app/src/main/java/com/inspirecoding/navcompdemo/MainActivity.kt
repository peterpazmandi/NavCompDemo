package com.inspirecoding.navcompdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.app_bar_with_fragment.*

class MainActivity : AppCompatActivity()
{
    private lateinit var navController: NavController

    private val appBarConfiguration by lazy {
        AppBarConfiguration(
            setOf(
                R.id.fragment_1,
                R.id.fragment_2,
                R.id.fragment_3,
                R.id.fragment_4
            ), drawer_layout
        )
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        navController = Navigation.findNavController(this, R.id.container)

        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        NavigationUI.setupActionBarWithNavController(
            this,
            navController,
            drawer_layout
        )

        drawer_layout.nav_view.setupWithNavController(
            container.findNavController()
        )

        NavigationUI.setupWithNavController(
            toolbar,
            navController,
            appBarConfiguration
        )
    }
}
