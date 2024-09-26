package com.example.trainingapp1.network.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.trainingapp1.R



data class Cities(
    @StringRes val name: Int?,
    @StringRes val review: Int?,
    @DrawableRes val image: Int?
)

val citiesList = listOf(
    Cities(
        R.string.CityName,
        R.string.Reviews,
        R.drawable.city1_img
    ),
    Cities(
        R.string.CityName,
        R.string.Reviews,
        R.drawable.city2_img),
    Cities(
        R.string.CityName,
        R.string.Reviews,
        R.drawable.city3_img),

)

