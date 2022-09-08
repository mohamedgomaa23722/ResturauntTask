package com.gomaa.resturanttask.data.Resturants

import com.squareup.moshi.Json

data class FullResturant(
    @Json(name = "delivery_time")
    val deliveryTime: Int = 0,
    @Json(name = "delivery_cost")
    val deliveryCost: Int = 0,
    @Json(name = "rate")
    val rate: Int? = null,
    @Json(name = "IsOpen")
    val isOpen: String ,
    @Json(name = "RestauranthId")
    override val restaurantId: Int = 0,
    @Json(name = "name")
    override val restaurantName: String = "",
    @Json(name = "logo")
    override val restaurantLogo: String = "",
    @Json(name = "cover")
    override val restaurantCover: String = "",
    @Json(name = "cuisines")
    override val cuisines: List<Cuisines>
) : BaseRestaurant
