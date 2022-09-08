package com.gomaa.resturanttask.data.offers

interface BaseOffer<T> {
    val title:String
    val data:List<T>
}