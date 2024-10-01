package com.example.trainingapp1.view.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Resource
import com.example.domain.usecase.login.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
):ViewModel(){

    private var _message = MutableLiveData("")

    val message get() = _message


    fun login(email:String,password:String){
        viewModelScope.launch {
            loginUseCase.execute(email = email ,password =password).collect{result->
                when(result){
                    is Resource.Fail -> {

                    }
                    Resource.Loading -> {

                    }
                    is Resource.ServerFail -> {

                    }
                    is Resource.Success -> {
                        message.value = result.data.name
                    }
                }
            }
        }
    }
}