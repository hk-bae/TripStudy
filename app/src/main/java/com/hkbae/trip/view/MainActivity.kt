package com.hkbae.trip.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.hkbae.trip.R
import com.hkbae.trip.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    fun onClickLogin(view: View) {
        val intent= Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
    }

    fun onCLickRegister(view: View) {
        val intent= Intent(this@MainActivity, RegisterActivity::class.java)
        startActivity(intent)
    }



}