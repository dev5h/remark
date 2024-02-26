package com.shazin.remark

sealed class Routes(
    val path: String,
){
    object Home: Routes("/home")
    object Details: Routes("/details/{id}")
}