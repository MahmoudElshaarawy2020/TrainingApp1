package com.example.domain.usecase.login

import com.example.domain.common.Resource
import com.example.domain.contract.login.LoginRepository
import com.example.domain.model.login.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend fun execute(email: String, password: String): Flow<Resource<User>> {
        return loginRepository.login(email = email, password = password)
    }
}