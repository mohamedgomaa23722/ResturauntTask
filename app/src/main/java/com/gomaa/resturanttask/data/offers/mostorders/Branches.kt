package com.gomaa.resturanttask.data.offers.mostorders

import com.gomaa.resturanttask.data.restaurants.SubRestaurant
import com.squareup.moshi.Json

data class Branches(
    val name: String,
    val id: Int,
    @Json(name= "restaurant")
    val restaurant: SubRestaurant
)

