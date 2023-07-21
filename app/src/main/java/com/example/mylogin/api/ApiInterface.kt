package com.example.mylogin.api

import com.example.mylogin.models.RegisterRequest
import com.example.mylogin.models.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/user/register")
    suspend fun registerUser(@Body registerRequest:RegisterRequest): Response<RegisterResponse>
}
