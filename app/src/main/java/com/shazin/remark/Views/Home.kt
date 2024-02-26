package com.shazin.remark.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navHostController: NavHostController){
    Scaffold {paddingValues ->
        Box(modifier =
        Modifier
            .fillMaxSize()
            .padding(paddingValues)
        )
    }
}

@Composable
fun HomeHeader(){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Notes", style = MaterialTheme.typography.displayLarge)
        // Search
    }
}
@Composable
fun SearchBarDisplay(){
    Box(modifier =
        Modifier
            .clip(RoundedCornerShape(25.dp))
            .fillMaxWidth(0.8f)
            .defaultMinSize(100.dp)
            .height(25.dp)
            .background(MaterialTheme.colorScheme.)
    )
    Card {

    }
}