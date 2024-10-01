package com.example.data.contract.login

import com.example.domain.model.login.User

interface LoginDataSource {

    suspend fun login(email:String,password:String):User
}