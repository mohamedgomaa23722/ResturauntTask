package com.gomaa.resturanttask.data.restaurants

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
interface  BaseRestaurant{
    val restaurantId: Int
    val restaurantName: String
    val restaurantLogo: String
    val restaurantCover: String
    val cuisines: List<Cuisines>
}