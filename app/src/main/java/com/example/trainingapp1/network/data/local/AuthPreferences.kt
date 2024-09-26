package com.example.trainingapp1.network.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.example.trainingapp1.util.Constants.AUTH_KEY

class AuthPreferences(private val dataStore:DataStore<Preferences>) {

    suspend fun saveAuthToken(loginToken:String){
        dataStore.edit { pref ->
            pref[AUTH_KEY] = setOf(loginToken)
        }
    }

}