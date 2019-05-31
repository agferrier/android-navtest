package com.example.navtest

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val navControllers by lazy {
        setOf(
            R.id.fragment_a_nav_controller,
            R.id.fragment_b_nav_controller
        )
            .map {
                it to findNavController(it)
            }.toMap()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar()
        setupBottomNavVisibilityHandler()
    }

    private fun setupBottomNavVisibilityHandler() {
        navControllers.keys.drop(1).forEach { id ->
            findViewById<View>(id).visibility = View.GONE
        }
        nav_view.setOnNavigationItemSelectedListener {
            navControllers.keys.forEach { id ->
                Log.d("xxx", "Setting visibility for ${resources.getResourceName(id)}: ${id == it.itemId}")
                val view = findViewById<View>(id)
                if (id == it.itemId) {
                    view.visibility = View.VISIBLE
                    navControllers[id]?.let { navController ->
                        val appBarConfiguration = AppBarConfiguration(navController.graph)
                        toolbar.setupWithNavController(navController, appBarConfiguration)
                    }
                } else {
                    view.visibility = View.GONE
                }
            }
            true
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
    }

}
