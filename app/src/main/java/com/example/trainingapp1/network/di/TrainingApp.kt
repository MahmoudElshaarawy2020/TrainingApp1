package com.example.trainingapp1.network.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TrainingApp : Application() {
    override fun onCreate() {
        super.onCreate()

    }
}