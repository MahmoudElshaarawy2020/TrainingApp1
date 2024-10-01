package com.example.data.repo.login

import com.example.data.contract.login.LoginDataSource
import com.example.data.utils.toFlow
import com.example.domain.common.Resource
import com.example.domain.contract.login.LoginRepository
import com.example.domain.model.login.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource
):LoginRepository {
    override suspend fun login(email: String, password: String): Flow<Resource<User>> {
        return  toFlow {
            loginDataSource.login(email = email,password= password)
        }
    }
}