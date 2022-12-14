package com.gomaa.resturanttask.data.offers.mostSellItem

import com.gomaa.resturanttask.data.categories.MenuCategory
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
