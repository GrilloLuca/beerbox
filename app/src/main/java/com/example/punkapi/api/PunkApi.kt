package com.example.punkapi.api

import com.example.punkapi.models.Beer
import com.example.punkapi.models.BeerDetail
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PunkApi {
    @GET("beers")
    suspend fun getBeers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("beer_name") beerName: String? = null,
    ): Response<List<Beer>>

    @GET("beers/{id}")
    suspend fun getBeer(@Path("id") id: Int): Response<BeerDetail>

    companion object {

        fun create(baseUrl: String) =
            ApiBuilder.createService(
                baseUrl = baseUrl,
                instance = PunkApi::class.java
            )

    }

}