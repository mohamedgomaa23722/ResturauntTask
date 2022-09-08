package com.gomaa.resturanttask.data.offers.MostSellItem

import com.gomaa.resturanttask.data.Categories.MenuCategory
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MostSellItem(
    @Json(name = "itemamount")
    val itemAmount: String,
    @Json(name = "itemtotal")
    val itemTotal: Int,
    @Json(name = "menu_categories_items")
    val menuCategory: MenuCategory
)
