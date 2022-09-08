package com.gomaa.resturanttask.data.Categories

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class MenuCategory(
    val descriptions: String,
    val descriptions_en: String,
    val menu_categories_id: Int,
    val price: Int,
    val created: String,
    val modified: String,
    val active: Int,
    @Json(name = "id")
    override val id: Int,
    @Json(name = "name_en")
    override val categoryNameEn: String,
    @Json(name = "name")
    override val categoryNameAr: String,
    @Json(name = "photo")
    override val CategoryImageUrl: String,
    override val percentage: Int = 0,
) : BaseCategory