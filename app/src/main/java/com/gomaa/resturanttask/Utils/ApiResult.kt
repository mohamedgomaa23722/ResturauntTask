package com.gomaa.resturanttask.Utils

sealed class ApiResult <out T> {
    object  Success:ApiResult<Nothing>()
    data class Error(val message: String): ApiResult<Nothing>()
    object Loading: ApiResult<Nothing>()
}