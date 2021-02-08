package com.hkbae.trip.service

import com.hkbae.trip.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface UserAPI {

    @GET("/user/all/")
    suspend fun getAllUsers()
    : Response<List<User>>

    @GET("/user/get/")
    suspend fun getUserById(
        @Query("idx") idx : Int
    ) : Call<User>

    @GET("/user/delete/")
    suspend fun deleteUserById( //id에 따른 사용자 정보 요청
        @Query("idx") idx : Int
    ) : Call<Unit>

    @POST("/user/post/")
    suspend fun postUser( //사용자 정보 insert 요청
        @Body user : User
    ):Call<User>

    @PUT("/user/update/")
    suspend fun updateUserById(
        @Query("idx") idx:Int
    ):Call<Unit>



}