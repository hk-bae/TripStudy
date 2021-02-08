package com.hkbae.trip.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.hkbae.trip.R
import com.hkbae.trip.databinding.ActivityTripBinding

class TripActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTripBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTripBinding.inflate(layoutInflater)
        val view =binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

    }

    fun initView(){

        setSupportActionBar(binding.tripToolbar)
        val actionBar=supportActionBar
        actionBar?.setDisplayShowTitleEnabled(false) //기존 타이틀 제거
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home ->{
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}