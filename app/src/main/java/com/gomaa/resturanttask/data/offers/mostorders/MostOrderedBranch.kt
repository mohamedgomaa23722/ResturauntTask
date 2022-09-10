package com.gomaa.resturanttask.data.offers.mostOrderBranches

import com.gomaa.resturanttask.data.offers.BaseOffer
import com.gomaa.resturanttask.data.restaurants.FullResturant

data class MostOrderedBranch(
    override val title: String,
    override val data: List<MostOrdered>
): BaseOffer<MostOrdered>
