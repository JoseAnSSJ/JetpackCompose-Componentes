package com.example.jetpackcomposecomponentes.model

import androidx.annotation.DrawableRes

data class SuperHero(
    val superHeroName: String,
    val realName: String,
    val publisher: String,
    @DrawableRes
    val photo: Int
)
