package com.example.trainingapp1.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Resource
import com.example.domain.usecase.login.LoginUseCase
import com.example.trainingapp1.utils.MessageError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private var _message = MutableLiveData("")

    private var _errorMessage = MutableLiveData<MessageError>()

    private var _loading = MutableStateFlow(false)

    val loading: StateFlow<Boolean> get() = _loading

    val errorMessage get() = _errorMessage

    val message get() = _message


    fun login(email: String, password: String) {
        viewModelScope.launch {
            loginUseCase.execute(email = email, password = password).collect { result ->
                when (result) {
                    is Resource.Fail -> {
                        _errorMessage.value = MessageError(
                            message = result.error.localizedMessage
                        )
                    }

                    Resource.Loading -> {
                        _loading.value = true
                    }

                    is Resource.ServerFail -> {
                        _errorMessage.value = MessageError(
                            message = result.serverError.message
                        )
                    }

                    is Resource.Success -> {
                        _message.value = result.data.name
                    }
                }
            }
        }
    }
}