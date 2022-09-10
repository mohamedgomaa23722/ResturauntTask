package com.gomaa.resturanttask.data.offers.mostorders

data class MostOrdered(
    val delivery_time: Int,
    val delivery_cost: Int,
    val ordersnumber: Int,
    val branches: Branches
)
