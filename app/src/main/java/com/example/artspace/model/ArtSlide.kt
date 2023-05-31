package com.example.artspace.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
data class ArtSlide(
    @DrawableRes val imageResourceId : Int,
    @StringRes val imageDescriptionId : Int,
    @StringRes val artistId : Int
)
