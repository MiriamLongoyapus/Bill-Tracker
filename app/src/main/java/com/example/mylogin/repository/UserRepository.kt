package com.example.mylogin.repository

import com.example.mylogin.api.ApiClient
import com.example.mylogin.api.ApiInterface
import com.example.mylogin.models.RegisterRequest
import com.example.mylogin.models.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var client = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun registerUser(registerRequest: RegisterRequest): Response<RegisterResponse> {
        return withContext(Dispatchers.IO) {
            client.registerUser(registerRequest)

        }

    }
}