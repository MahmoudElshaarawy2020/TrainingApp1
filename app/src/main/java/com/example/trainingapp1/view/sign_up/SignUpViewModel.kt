package com.example.trainingapp1.view.sign_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingapp1.network.data.remote.request.SignUpRequest
import com.example.trainingapp1.network.data.remote.response.SignUpResponse
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
class SignUpViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    // StateFlow to manage the sign-up result, observed by the UI
    private val _signUpResult = MutableStateFlow<Result<SignUpResponse>?>(null)
    val signUpResult: StateFlow<Result<SignUpResponse>?> = _signUpResult.asStateFlow()

    // Sign-up function that communicates with the repository and updates the state
    fun signUp(signUpRequest: SignUpRequest) {
        viewModelScope.launch {
            _signUpResult.value = try {
                val response = userRepository.signUp(signUpRequest)
                if (response.isSuccessful && response.body() != null) {
                    Result.success(response.body()!!)
                } else {
                    // Extract the error message from the error body if available
                    val errorMessage = response.errorBody()?.string() ?: "Unknown error"

                    // Handle the error as a failure with a detailed message
                    Result.failure(Exception("API error: $errorMessage"))
                }
            } catch (e: HttpException) {
                Result.failure(Exception("HTTP error: ${e.message}"))
            } catch (e: IOException) {
                Result.failure(Exception("Network error: ${e.message}"))
            } catch (e: Exception) {
                Result.failure(Exception("Unexpected error: ${e.message}"))
            }
        }
    }
}