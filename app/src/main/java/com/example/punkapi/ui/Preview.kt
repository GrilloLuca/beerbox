package com.example.punkapi.ui

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.punkapi.models.Beer

class BeerItemPreview : PreviewParameterProvider<List<Beer>> {

    override val values: Sequence<List<Beer>>
        get() = sequenceOf(
            listOf(
                Beer(
                    id = 192,
                    name = "Punk IPA 2007 - 2010",
                    tagline = "Post Modern Classic. Spiky. Tropical. Hoppy.",
                    first_brewed = "04/2007",
                    description = "Our flagship beer that kick started the craft beer revolution. This is James and Martin's original take on an American IPA, subverted with punchy New Zealand hops. Layered with new world hops to create an all-out riot of grapefruit, pineapple and lychee before a spiky, mouth-puckering bitter finish.",
                    image_url = "https://images.punkapi.com/v2/192.png",
                    abv = 6.0,
                    ibu = 60.0,
                    target_fg = 1010.0,
                    target_og = 1056.0,
                    ebc = 17.0,
                    srm = 8.5,
                    ph = 4.4,
                    attenuation_level = 82.14,
                ),
                Beer(
                    id = 1,
                    name = "Buzz",
                    tagline = "A Real Bitter Experience.",
                    first_brewed = "09/2007",
                    description = "A light, crisp and bitter IPA brewed with English and American hops. A small batch brewed only once.",
                    image_url = "https://images.punkapi.com/v2/keg.png",
                    abv = 4.5,
                    ibu = 60.0,
                    target_fg = 1010.0,
                    target_og = 1044.0,
                    ebc = 20.0,
                    srm = 10.0,
                    ph = 4.4,
                    attenuation_level = 75.0,
                )
            )
        )

}