package com.shazin.remark

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shazin.remark.Views.Home

@Composable
fun Root(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = Routes.Home.path){
        composable(Routes.Home.path){
            Home(navHostController = navHostController)
        }
    }
}