package com.inspirecoding.navcompdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

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
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        //Getting the Navigation Controller
        navController = Navigation.findNavController(this, R.id.container)

        //Setting the navigation controller to Bottom Nav
        bottom_nav.setupWithNavController(navController)

        //Setting up the action bar
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id)
            {
                R.id.fragment_5 -> hideBottomNav()
                else -> showBottomNav()
            }
        }
    }

    private fun showBottomNav()
    {
        bottom_nav.visibility = View.VISIBLE
    }

    private fun hideBottomNav()
    {
        bottom_nav.visibility = View.GONE
    }
}
