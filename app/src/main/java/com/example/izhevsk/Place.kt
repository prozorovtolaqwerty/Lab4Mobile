package com.example.izhevsk

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place(
    val id: String,
    val categoryId: String,
    @StringRes val nameRes: Int,
    @StringRes val summaryRes: Int,
    @StringRes val detailRes: Int,
    @DrawableRes val iconRes: Int,
)
