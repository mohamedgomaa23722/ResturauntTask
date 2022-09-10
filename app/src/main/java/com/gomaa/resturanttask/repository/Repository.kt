package com.gomaa.resturanttask.repository

import com.gomaa.resturanttask.data.ads.AdsResponse
import com.gomaa.resturanttask.data.categories.Category
import com.gomaa.resturanttask.data.offers.OfferResponse
import com.gomaa.resturanttask.di.annotations.*
import com.gomaa.resturanttask.network.ServiceApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(
    @AuthApiServiceGet private val serviceApiGet: ServiceApi,
    @AuthApiServicePost private val serviceApiPost: ServiceApi
) {
    /**
     * Method which get all categories from Api Service
     */
    fun categories(): Flow<List<Category>> = flow {
        emit(serviceApiGet.GetCategoryList())
    }.flowOn(Dispatchers.IO)

    /**
     * Method which return all slider ads data from Api Service
     */
    fun SliderAds(): Flow<List<AdsResponse>> = flow {
        emit(serviceApiPost.PostSliderData())
    }.flowOn(Dispatchers.IO)

    /**
     * Method which return OfferResponse from Api Service
     */
    fun BestOffers(): Flow<OfferResponse> = flow {
        emit(serviceApiPost.PostOffersData())
    }.flowOn(Dispatchers.IO)
}