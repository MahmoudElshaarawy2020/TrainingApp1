package com.example.domain.common

sealed class Resource<out T> {

    data object Loading : Resource<Nothing>()

    data class Success<Type>(val data: Type) : Resource<Type>()

    data class Fail(val error: Throwable) : Resource<Nothing>()

    data class ServerFail(val serverError: ServerError) : Resource<Nothing>()
}

