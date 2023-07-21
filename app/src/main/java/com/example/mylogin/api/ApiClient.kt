package com.example.mylogin.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {

    var retrofit =  Retrofit.Builder()
        .baseUrl("http://13.37.106.218")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun buildApiClient(java: Class<ApiInterface>): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }
}
