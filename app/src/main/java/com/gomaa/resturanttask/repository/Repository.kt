package com.gomaa.resturanttask.repository

import android.util.Log
import com.gomaa.resturanttask.data.Ads.AdsResponse
import com.gomaa.resturanttask.data.Categories.Category
import com.gomaa.resturanttask.data.offers.OfferResponse
import com.gomaa.resturanttask.di.annotations.AuthApiService
import com.gomaa.resturanttask.di.annotations.AuthBody
import com.gomaa.resturanttask.network.ServiceApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import okhttp3.RequestBody
import org.json.JSONObject
import javax.inject.Inject

class Repository @Inject constructor(
    @AuthApiService private val serviceApi: ServiceApi,
    @AuthBody private val requestBody: RequestBody
) {
    /**
     * Method which get all categories from data base after cached data
     * into room database
     */
    fun categories(): Flow<List<Category>> = flow {
        emit(serviceApi.GetCategoryList())
    }.flowOn(Dispatchers.IO)

    /**
     * Method which return all slider ads data from data base after it has
     * been cached
     */
    fun SliderAds(): Flow<List<AdsResponse>> = flow {
        emit(serviceApi.PostSliderData(requestBody))
    }.flowOn(Dispatchers.IO)

    /**
     * Method which return best Dishes in the market
     */
    fun BestOffers(): Flow<OfferResponse> = flow {
        emit(serviceApi.PostOffersData(requestBody))
    }.flowOn(Dispatchers.IO)
}