package com.example.punkapi.models

import com.google.gson.annotations.SerializedName

data class Beer(
    val id: Int,
    val name: String? = null,
    val tagline: String? = null,
    val description: String? = null,
    @SerializedName("image") val image_url: String? = null,
)
