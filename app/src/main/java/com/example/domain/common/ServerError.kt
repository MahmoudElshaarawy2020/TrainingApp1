package com.example.domain.common

data class ServerError(
    val serverMessage: String? = null,
    val serverCode: Boolean? = null,
    val http: Throwable? = null
) : Throwable(serverMessage, http) {
}