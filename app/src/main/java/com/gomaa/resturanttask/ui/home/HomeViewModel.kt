package com.gomaa.resturanttask.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gomaa.resturanttask.Utils.ApiResult
import com.gomaa.resturanttask.data.ads.AdsResponse
import com.gomaa.resturanttask.data.restaurants.FullResturant
import com.gomaa.resturanttask.data.categories.Category
import com.gomaa.resturanttask.data.offers.mostorders.MostOrdered
import com.gomaa.resturanttask.data.offers.mostSellItem.MostSellItem
import com.gomaa.resturanttask.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    //This is all MutableStateFlow for our response
    private val _statue: MutableStateFlow<ApiResult<Nothing>> = MutableStateFlow(ApiResult.Loading)
    private val _categoryMutableList: MutableStateFlow<List<Category>> = MutableStateFlow(listOf())
    private val _vendorMutableList: MutableStateFlow<List<FullResturant>> =
        MutableStateFlow(listOf())
    private val _lastOffersMutableList: MutableStateFlow<List<FullResturant>> =
        MutableStateFlow(listOf())
    private val _mostSellItemsMutableList: MutableStateFlow<List<MostSellItem>> =
        MutableStateFlow(listOf())
    private val _nearestBranchMutableList: MutableStateFlow<List<FullResturant>> =
        MutableStateFlow(listOf())
    private val _freeDeliveryBranchesMutableList: MutableStateFlow<List<FullResturant>> =
        MutableStateFlow(listOf())
    private val _adsMutableList: MutableStateFlow<List<AdsResponse>> = MutableStateFlow(listOf())
    private val _mostOrderedBranchesMutableList: MutableStateFlow<List<MostOrdered>> =
        MutableStateFlow(listOf())

    //This is all StateFlow for our response
    val statue: StateFlow<ApiResult<Nothing>> get() = _statue
    val categoryLiveData: StateFlow<List<Category>> get() = _categoryMutableList
    val vendorData: StateFlow<List<FullResturant>> get() = _vendorMutableList
    val lastOffersData: StateFlow<List<FullResturant>> get() = _lastOffersMutableList
    val mostSellItemsData: StateFlow<List<MostSellItem>> get() = _mostSellItemsMutableList
    val nearestBranchData: StateFlow<List<FullResturant>> get() = _nearestBranchMutableList
    val freeDeliveryBranchesData: StateFlow<List<FullResturant>> get() = _freeDeliveryBranchesMutableList
    val AdsData: StateFlow<List<AdsResponse>> get() = _adsMutableList
    val mostOrderedBranchesData: StateFlow<List<MostOrdered>> get() = _mostOrderedBranchesMutableList


    init {
        refreshCategories()
        refreshOffers()
        refreshAds()
    }

    /**
     * refreshCategories function for getting the values of categories from
     * the repository
     */
    private fun refreshCategories() = viewModelScope.launch(Dispatchers.IO) {
        repository.categories()
            .catch { e ->
                _statue.value = ApiResult.Error(e.message!!)
                Log.d("connection error", "refreshCategories: ${e.message}")
            }.collect { data ->
                _categoryMutableList.value = data
            }
    }

    /**
     * refreshOffers function for getting the values of offersResponse from
     * the repository
     */
    private fun refreshOffers() = viewModelScope.launch(Dispatchers.IO) {
        repository.BestOffers()
            .catch { e ->
                _statue.value = ApiResult.Error(e.message!!)
                Log.d("connection error", "refreshOffers: ${e.message}")
            }.collect { data ->
                _vendorMutableList.value = listOf(data.GetPercentageForVendors.data[0].restaurants)
                _lastOffersMutableList.value = data.lastOffers.data
                _mostSellItemsMutableList.value = data.MostSellItems.data
                _nearestBranchMutableList.value = data.GetNearestBranch.data
                _freeDeliveryBranchesMutableList.value = data.GetFreeDeliveryBranches.data
                _mostOrderedBranchesMutableList.value = data.mostOrderedBranch.data

                for(i in _mostOrderedBranchesMutableList.value){
                    Log.d("last test", "refreshOffers: logo: ${i.branches.restaurant.restaurantLogo}, name:${i.branches.restaurant.restaurantName}, cover:${i.branches.restaurant.restaurantCover}, id: ${i.branches.restaurant.restaurantId} ")
                }
            }
    }

    /**
     * refreshAds function for getting the values of AdsResponse from
     * the repository
     */
    private fun refreshAds() = viewModelScope.launch(Dispatchers.IO) {
        repository.SliderAds()
            .catch { e ->
                _statue.value = ApiResult.Error(e.message!!)
                Log.d("connection error", "refreshOffers: ${e.message}")
            }.collect { data ->
                _adsMutableList.value = data
                Log.d("response", "refreshAds: ${data[0].AdsSpacesprice.size}")
                _statue.value = ApiResult.Success
            }
    }
}