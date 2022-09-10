package com.gomaa.resturanttask.data.categories

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Category(
    @Json(name = "id")
    override val id: Int,
    @Json(name = "name_en")
    override val categoryNameEn: String,
    @Json(name = "name")
    override val categoryNameAr: String,
    @Json(name = "photo")
    override val CategoryImageUrl: String,
    override val percentage: Int = 0,
):BaseCategory
