package com.gomaa.resturanttask.ui.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gomaa.resturanttask.Utils.ApiResult
import com.gomaa.resturanttask.data.Categories.Category
import com.gomaa.resturanttask.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class HomeViewModel @Inject constructor( private val repository: Repository): ViewModel() {

    fun test1(){
        viewModelScope.launch{
            Log.d("TAG", "test1: "+repository.categories())
            repository.BestOffers()
            repository.SliderAds()
        }
    }

    private val postStateFlow: MutableStateFlow<ApiResult<List<Category>>>
            = MutableStateFlow(ApiResult.Loading)

    val _postStateFlow: StateFlow<ApiResult<List<Category>>> = postStateFlow

    fun getPost() = viewModelScope.launch {
        postStateFlow.value = ApiResult.Loading
        repository.categories()
            .catch { e->
                postStateFlow.value=ApiResult.Error(e.message!!)
            }.collect { data->
                postStateFlow.value=ApiResult.Success(data)
            }
    }
}