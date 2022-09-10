package com.gomaa.resturanttask.data.ads

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AdsResponse(
    val id: Int,
    val name: String,
    @Json(name = "created")
    val CreationDate: String?=null,
    val AdsSpacesprice: List<AdsSpacesPrice>
)

