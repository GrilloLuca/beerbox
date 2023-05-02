package com.example.punkapi.models

data class Beer(
    val id: Int,
    val name: String? = null,
    val tagline: String? = null,
    val description: String? = null,
    val image_url: String? = null,
)
