package com.example.punkapi.api

import com.example.punkapi.models.Beer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PunkApi {
    @GET("v2/beers")
    fun randomBeer(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int,
    ): Call<List<Beer>>?

    companion object {

        fun create(baseUrl: String) =
            ApiBuilder.createService(
                baseUrl = baseUrl,
                instance = PunkApi::class.java
            )

    }

}