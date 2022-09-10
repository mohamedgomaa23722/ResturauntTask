package com.gomaa.resturanttask.network

import com.gomaa.resturanttask.Utils.Constants.CATEGORY_END_POINT
import com.gomaa.resturanttask.Utils.Constants.MAIN_SLIDER_END_POINT
import com.gomaa.resturanttask.Utils.Constants.OFFERS_END_POINT
import com.gomaa.resturanttask.data.ads.AdsResponse
import com.gomaa.resturanttask.data.categories.Category
import com.gomaa.resturanttask.data.offers.OfferResponse
import retrofit2.http.*

interface ServiceApi {
    /**
     * this suspend function help us to post the slider end point
     * as you are define in the doc of the task and return the response
     * in form of Ads data class.
     */
    @POST(MAIN_SLIDER_END_POINT)
    suspend fun PostSliderData():List<AdsResponse>

    /**
     * This suspend function send get request to the server to receive
     * list of Category Data
     */
    @GET(CATEGORY_END_POINT)
    suspend fun GetCategoryList():List<Category>

    /**
     *This suspend function return json object which include different offers and resturant
     * data.
     */
    @POST(OFFERS_END_POINT)
    suspend fun PostOffersData():OfferResponse

}