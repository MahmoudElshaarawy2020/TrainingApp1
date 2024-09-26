package com.example.trainingapp1.viewmodel

sealed class UiEvents {
    data class SnackbarEvent(val message : String) : UiEvents()
    data class NavigateEvent(val route: String) : UiEvents()
}