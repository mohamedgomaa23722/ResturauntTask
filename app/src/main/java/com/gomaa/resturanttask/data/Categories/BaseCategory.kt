package com.gomaa.resturanttask.data.Categories

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

interface  BaseCategory{
    @Json(name = "id")
    val id: Int
    @Json(name = "name_en")
    val categoryNameEn: String
    @Json(name = "name")
    val categoryNameAr: String
    @Json(name = "photo")
    val CategoryImageUrl: String
    val percentage:Int
}

