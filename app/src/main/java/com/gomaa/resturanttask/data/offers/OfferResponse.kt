package com.gomaa.resturanttask.data.offers

import com.gomaa.resturanttask.data.offers.MostSellItem.MostSellItems
import com.gomaa.resturanttask.data.offers.PercentageForVendor.PercentageForVendors
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OfferResponse(
    val GetPercentageForVendors: PercentageForVendors,
    @Json(name = "lastoffers")
    val lastOffers: LastOffers,
    val MostSellItems: MostSellItems,
    @Json(name = "GetNearestBranche")
    val GetNearestBranch: LastOffers,
    @Json(name = "GetFreeDliveryBranches")
    val GetFreeDeliveryBranches: LastOffers

)
