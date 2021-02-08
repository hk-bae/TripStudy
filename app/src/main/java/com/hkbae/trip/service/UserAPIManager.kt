package com.hkbae.trip.service

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserAPIManager {

    private const val SERVER_URL = "http://172.29.157.56:8090"

    var retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(SERVER_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    var service : UserAPI = retrofit.create(UserAPI::class.java)
}