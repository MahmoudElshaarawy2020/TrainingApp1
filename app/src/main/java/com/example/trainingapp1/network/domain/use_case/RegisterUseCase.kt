package com.example.trainingapp1.network.domain.use_case

import com.example.trainingapp1.network.data.remote.request.AuthRequest
import com.example.trainingapp1.network.domain.model.AuthResult
import com.example.trainingapp1.network.domain.repository.AuthRepository

class RegisterUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        email:String,
        password:String
    ):AuthResult {

        val emailError = if (email.isBlank()) "Username cannot be blank" else null
        val passwordError = if (password.isBlank()) "Password cannot be blank" else null

        if (emailError != null){
            return AuthResult(
                emailError = emailError
            )
        }

        if (passwordError!=null){
            return AuthResult(
                passwordError = passwordError
            )
        }

        val registerRequest = AuthRequest(
            email = email.trim(),
            password = password.trim()
        )

        return AuthResult(
            result = repository.register(registerRequest)
        )
    }
}