package com.example.domain.contract.login

import com.example.domain.common.Resource
import com.example.domain.model.login.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    suspend fun login(email:String,password:String):Flow<Resource<User>>
}