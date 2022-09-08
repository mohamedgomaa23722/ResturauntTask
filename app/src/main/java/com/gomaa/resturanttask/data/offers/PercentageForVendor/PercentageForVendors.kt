package com.gomaa.resturanttask.data.offers.PercentageForVendor

import com.gomaa.resturanttask.data.offers.BaseOffer
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PercentageForVendors(
    override val title: String,
    override val data: List<VendorsData>
) : BaseOffer<VendorsData>
