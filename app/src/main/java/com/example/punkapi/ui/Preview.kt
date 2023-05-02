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
                    description = "Our flagship beer that kick started the craft beer revolution. This is James and Martin's original take on an American IPA, subverted with punchy New Zealand hops. Layered with new world hops to create an all-out riot of grapefruit, pineapple and lychee before a spiky, mouth-puckering bitter finish.",
                    image_url = "https://images.punkapi.com/v2/192.png",
                ),
                Beer(
                    id = 1,
                    name = "Buzz",
                    tagline = "A Real Bitter Experience.",
                    description = "A light, crisp and bitter IPA brewed with English and American hops. A small batch brewed only once.",
                    image_url = "https://images.punkapi.com/v2/keg.png",
                )
            )
        )

}