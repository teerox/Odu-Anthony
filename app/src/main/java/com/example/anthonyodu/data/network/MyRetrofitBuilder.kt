package com.example.anthonyodu.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofitBuilder {
    private const val BASE_URL = "https://android-json-test-api.herokuapp.com/"

    private val httpClient = okhttp3.OkHttpClient()
    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideMovieApi(): ApiService{
        return provideRetrofit().create(ApiService::class.java)
    }
}