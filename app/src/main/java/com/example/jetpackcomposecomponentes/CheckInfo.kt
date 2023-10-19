package com.example.jetpackcomposecomponentes

data class CheckInfo (
    var title: String,
    var selected: Boolean = false,
    var onCheckedChange:(Boolean) -> Unit
        )