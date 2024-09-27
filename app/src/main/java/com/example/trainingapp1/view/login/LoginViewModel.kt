package com.example.trainingapp1.view.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingapp1.network.data.remote.request.LoginRequest
import com.example.trainingapp1.network.data.remote.response.LoginResponse
import com.example.trainingapp1.network.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _loginResult = MutableStateFlow<Result<LoginResponse>?>(null)
    val loginResult: StateFlow<Result<LoginResponse>?> = _loginResult.asStateFlow()

    // Login function with error and success handling
    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            try {
                val response = userRepository.login(loginRequest)
                if (response.isSuccessful && response.body() != null) {
                    // Handle success
                    _loginResult.value = Result.success(response.body()!!)
                } else {
                    val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                    _loginResult.value = Result.failure(Exception("API error: $errorMessage"))
                }
            } catch (e: HttpException) {
                // Handle HTTP exceptions
                _loginResult.value = Result.failure(Exception("HTTP error: ${e.message}"))
            } catch (e: IOException) {
                // Handle network failures
                _loginResult.value = Result.failure(Exception("Network error: ${e.message}"))
            } catch (e: Exception) {
                // Handle unexpected exceptions
                _loginResult.value = Result.failure(Exception("Unexpected error: ${e.message}"))
            }
        }
    }
}