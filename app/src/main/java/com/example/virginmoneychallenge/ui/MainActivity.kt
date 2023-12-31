package com.example.virginmoneychallenge.ui

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.virginmoneychallenge.R
import com.example.virginmoneychallenge.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_people, R.id.navigation_rooms
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Hide navbar while loin screen is in view
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_login -> {
                    navView.visibility = View.GONE
                    binding.container.setPadding(0, 0, 0, 0) // remove padding
                }
                else -> {
                    navView.visibility = View.VISIBLE
                    val paddingTop = TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_PX,
                            TypedValue.COMPLEX_UNIT_DIP.toFloat(),
                            resources.displayMetrics).toInt().toFloat(),
                        resources.displayMetrics
                    )
                    binding.container.setPadding(0, paddingTop.toInt(), 0, 0) // add padding
                }
            }
        }
    }
}