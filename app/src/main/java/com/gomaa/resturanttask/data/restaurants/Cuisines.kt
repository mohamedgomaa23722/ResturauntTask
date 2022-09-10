package com.gomaa.resturanttask.data.Resturants

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cuisines(
    @Json(name = "id")
    val cuisinesId:Int,
    @Json(name = "name")
    val cuisinesName:String
)
