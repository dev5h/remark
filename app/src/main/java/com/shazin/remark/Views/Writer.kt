package com.shazin.remark.Views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun Writer(navHostController: NavHostController){
    Scaffold {paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues))
    }
}