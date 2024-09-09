package com.example.trainingapp1.model

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class LoginRepository(private val apiService: LoginApiService) {

    fun login(username: String, password: String): Flow<Result<LoginResponse>> = flow {
        val request = LoginRequest(username, password)
        emit(Result.success(apiService.login(request)))
    }.catch { e ->
        emit(Result.failure(e))
    }
}
