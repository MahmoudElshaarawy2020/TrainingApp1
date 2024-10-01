package com.example.data.datasource.login

import com.example.data.api.WebService
import com.example.data.contract.login.LoginDataSource
import com.example.data.utils.safeApiAuth
import com.example.domain.model.login.User
import javax.inject.Inject

class LoginDataSourceImpl @Inject constructor(
    private val webService: WebService
) : LoginDataSource {
    override suspend fun login(email: String, password: String): User {
        return safeApiAuth {
            val user = webService.login(email = email, password = password).userDto?.let {
                it.toUser()
            }
            user!!
        }
    }
}