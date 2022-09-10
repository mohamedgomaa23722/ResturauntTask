package com.gomaa.resturanttask.data.offers.mostorders

import com.gomaa.resturanttask.data.offers.BaseOffer

data class MostOrderedBranch(
    override val title: String,
    override val data: List<MostOrdered>
): BaseOffer<MostOrdered>
