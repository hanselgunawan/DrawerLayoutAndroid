package com.hanseltritama.drawerlayoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.navigation_view.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var actionBarToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionBarToggle = ActionBarDrawerToggle(this, drawer_layout, 0, 0)
        drawer_layout.addDrawerListener(actionBarToggle)

        // Display the hamburger icon to launch the drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Call syncState() on the action bar so it'll automatically change to the back button when the drawer layout is open
        actionBarToggle.syncState()

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.myProfile -> {
                    Toast.makeText(this, "My Profile", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.people -> {
                    Toast.makeText(this, "People", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.settings -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        drawer_layout.openDrawer(navView)
        return true
    }

    override fun onBackPressed() {
        if (this.drawer_layout.isDrawerOpen(GravityCompat.START)) {
            this.drawer_layout.closeDrawer(GravityCompat.END)
        } else {
            super.onBackPressed()
        }
    }
}
