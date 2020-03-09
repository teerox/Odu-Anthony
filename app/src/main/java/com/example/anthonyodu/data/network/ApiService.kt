package com.example.anthonyodu.network


import com.example.anthonyodu.model.FilterArray
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {

    @GET("accounts")
    fun getAllFilterAsync(): Call<FilterArray>
}