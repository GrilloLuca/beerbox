package com.example.punkapi.api.repo

import okhttp3.ResponseBody

sealed class Resource<T>(val data: T? = null, val error: String? = null) {

    class Success<T>(data: T?): Resource<T>(data)

    class Error<T>(error: String?): Resource<T>(null, error)
}