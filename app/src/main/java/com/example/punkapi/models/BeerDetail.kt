package com.example.punkapi.models

data class BeerDetail(
    val id: Int,
    val name: String? = null,
    val tagline: String? = null,
    val first_brewed: String? = null,
    val description: String? = null,
    val image: String? = null,
    val abv: Double? = null,
    val ibu: Int? = null,
    val target_fg: Int? = null,
    val target_og: Int? = null,
    val ebc: Int? = null,
    val srm: Double? = null,
    val ph: Double? = null,
    val attenuation_level: Double? = null,
    val volume: Volume? = null,
    val boil_volume: Volume? = null,
    val method: Method? = null,
    val ingredients: Ingredients? = null,
    val food_pairing: List<String>? = null,
    val brewers_tips: String? = null,
    val contributed_by: String? = null
)

data class Volume(
    val value: Int? = null,
    val unit: String? = null
)

data class Method(
    val mash_temp: List<MashTemp>? = null,
    val fermentation: Fermentation? = null,
    val twist: String? = null
)

data class MashTemp(
    val temp: Temp? = null,
    val duration: Int? = null
)

data class Temp(
    val value: Int? = null,
    val unit: String? = null
)

data class Fermentation(
    val temp: Temp? = null
)

data class Ingredients(
    val malt: List<Malt>? = null,
    val hops: List<Hop>? = null,
    val yeast: String? = null
)

data class Malt(
    val name: String? = null,
    val amount: Amount? = null
)

data class Amount(
    val value: Double? = null,
    val unit: String? = null
)

data class Hop(
    val name: String? = null,
    val amount: Amount? = null,
    val add: String? = null,
    val attribute: String? = null
)
