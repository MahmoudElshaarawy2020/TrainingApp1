package com.example.trainingapp1.network.data

import okhttp3.ResponseBody
import retrofit2.http.Body

sealed class Response<out T> {
    data class Success<out T>(val value: T): Response<T>()

    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ): Response<Nothing>()
}