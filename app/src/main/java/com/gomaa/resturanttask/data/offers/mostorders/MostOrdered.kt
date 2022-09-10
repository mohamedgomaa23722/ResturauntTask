package com.gomaa.resturanttask.data.offers.mostOrderBranches

data class MostOrdered(
    val delivery_time: Int,
    val delivery_cost: Int,
    val ordersnumber: Int,
    val branches: Branches
)
