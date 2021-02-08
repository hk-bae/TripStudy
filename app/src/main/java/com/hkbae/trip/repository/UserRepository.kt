package com.hkbae.trip.repository

import com.hkbae.trip.service.UserAPIManager


class UserRepository {

    suspend fun getAllUsers()=UserAPIManager.service.getAllUsers()

}