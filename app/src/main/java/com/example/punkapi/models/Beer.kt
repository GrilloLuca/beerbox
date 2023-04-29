package com.example.punkapi.models

data class Beer(
    val id: Int,
    val name: String,
    val tagline: String,
    val first_brewed: String,
    val description: String,
    val image_url: String,
    val abv: Double,
    val ibu: Double,
    val target_fg: Double,
    val target_og: Double,
    val ebc: Double,
    val srm: Double,
    val ph: Double,
    val attenuation_level: Double,
)
