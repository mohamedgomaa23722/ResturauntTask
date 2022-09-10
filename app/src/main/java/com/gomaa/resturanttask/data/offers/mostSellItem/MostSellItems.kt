package com.gomaa.resturanttask.data.offers.mostSellItem

import com.gomaa.resturanttask.data.offers.BaseOffer
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MostSellItems(
    override val title: String,
    override val data: List<MostSellItem>
) : BaseOffer<MostSellItem>
