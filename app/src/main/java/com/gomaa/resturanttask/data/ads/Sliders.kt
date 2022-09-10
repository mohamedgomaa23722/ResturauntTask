package com.gomaa.resturanttask.data.ads

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sliders(
    @Json(name = "id")
    val id: Int,
    @Json(name = "photo")
    val sliderImageURl: String,
    @Json(name = "created")
    val createdDate: String,
    @Json(name = "modified")
    val modifiedDate: String,
    @Json(name = "slider_seconds")
    val sliderSeconds: Int,
    @Json(name = "item_id")
    val itemId: Int,
    @Json(name = "restaurant_id")
    val restaurantId: Int,
    @Json(name = "approval")
    val approval: Int,
    @Json(name = "department_id")
    val departmentId: Int,
    @Json(name = "ads_position_price_id")
    val adsPositionPriceId: Int,
    @Json(name = "total_cost")
    val totalCost: Int,
    @Json(name = "start_date")
    val startDate: String,
    @Json(name = "end_date")
    val endDate: String,
    @Json(name = "day_number")
    val dayNumber: Int,
    @Json(name = "department_message")
    val departmentMessage: String,
    @Json(name = "publish")
    val publish: Int
)