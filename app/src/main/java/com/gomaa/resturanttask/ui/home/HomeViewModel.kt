package com.gomaa.resturanttask.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gomaa.resturanttask.Utils.ApiResult
import com.gomaa.resturanttask.data.categories.Category
import com.gomaa.resturanttask.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _categoryMutableList: MutableLiveData<List<Category>> =
        MutableLiveData()

    init {
        viewModelScope.launch {
            _categoryMutableList.value = repository.RefreshCategories()
            Log.d("TAG", "after getPost stateFlow: ${_categoryMutableList.value?.size}")
        }
        getPost()
        Log.d("TAG", "after getPost stateFlow: ${_categoryMutableList.value?.size}")
    }

    val categoryLiveData: LiveData<List<Category>?>
        get()
        = _categoryMutableList

    fun getPost() {
        viewModelScope.launch {
            _categoryMutableList.value = repository.categories()
            Log.d("TAG", "after getPost stateFlow: ${_categoryMutableList.value?.size}")
        }
    }
}