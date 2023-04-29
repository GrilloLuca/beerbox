package com.example.punkapi.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiBuilder {

    private fun createClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        return httpClient.build()
    }

    fun<T> createService(
        baseUrl: String,
        instance: Class<T>
    ): T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(instance)
    }
}