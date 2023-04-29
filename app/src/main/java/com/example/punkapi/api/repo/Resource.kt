package com.example.punkapi.api.repo

import okhttp3.ResponseBody

sealed class Resource<T>(val data: T? = null, val error: ResponseBody? = null) {

    class Success<T>(data: T?): Resource<T>(data)

    class Error<T>(error: ResponseBody?): Resource<T>(null, error)
}