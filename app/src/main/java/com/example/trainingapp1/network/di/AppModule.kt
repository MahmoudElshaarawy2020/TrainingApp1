package com.example.trainingapp1.network.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import com.example.trainingapp1.network.data.local.AuthPreferences
import com.example.trainingapp1.network.data.remote.ApiService
import com.example.trainingapp1.network.data.repository.AuthRepositoryImpl
import com.example.trainingapp1.network.domain.repository.AuthRepository
import com.example.trainingapp1.network.domain.use_case.LoginUseCase
import com.example.trainingapp1.network.domain.use_case.RegisterUseCase
import com.example.trainingapp1.util.Constants.AUTH_PREFERENCES
import com.example.trainingapp1.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.prefs.Preferences
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://android-training.appssquare.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideUserRepository(apiService: ApiService): UserRepository {
        return UserRepository(apiService)
    }
}