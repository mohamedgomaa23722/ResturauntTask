package com.gomaa.resturanttask.data.offers

import com.gomaa.resturanttask.data.Resturants.FullResturant
import com.squareup.moshi.JsonClass

/**
 * This Data class to generate (last offers) list of data or (GetNearestBranch) or (GetFreeDeliveryBranches)
 */
@JsonClass(generateAdapter = true)
data class LastOffers(
    override val title: String,
    override val data: List<FullResturant>
):BaseOffer<FullResturant>
