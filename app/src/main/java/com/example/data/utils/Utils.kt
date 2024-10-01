package com.example.data.utils

import com.example.data.models.auth.AuthResponse
import com.example.domain.common.InternetConnection
import com.example.domain.common.Resource
import com.example.domain.common.ServerError
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiAuth(apiCall: suspend () -> T): T {

    try {
        val response = apiCall.invoke()
        return response
    } catch (ex: HttpException) {
        if (ex.code() in 400..600) {
            val serverMessage = ex.response()?.errorBody()?.string()
            val serverCode = Gson().fromJson(serverMessage, AuthResponse::class.java)
            throw ServerError(serverMessage, serverCode.status, ex)
        }
        throw ex
    } catch (ex: IOException) {
        throw InternetConnection(ex)
    } catch (ex: Exception) {
        throw ex
    }
}

suspend fun <T> toFlow(getData: suspend () -> T): Flow<Resource<T>> {
    return flow {
        emit(Resource.Loading)
        val response = getData.invoke()
        emit(Resource.Success(response))
    }.catch { ex ->
        when (ex) {
            is ServerError -> {
                emit(Resource.ServerFail(ServerError(ex.serverMessage, ex.serverCode, ex)))
            }

            is IOException -> {
                emit(Resource.Fail(ex))
            }

            else -> {
                emit(Resource.Fail(ex))
            }
        }
    }
}

