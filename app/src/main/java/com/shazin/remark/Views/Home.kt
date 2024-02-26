package com.shazin.remark.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
        LazyColumn(modifier =
        Modifier
            .fillMaxSize()
            .padding(paddingValues)
        ){
            item {
                HomeHeader()
            }
        }
    }
}

@Composable
fun HomeHeader(){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Notes", style = MaterialTheme.typography.displayLarge)
        // Search
        SearchBox()
    }
}
@Composable
fun SearchBox(){
    Box(modifier =
    Modifier
        .clip(RoundedCornerShape(25.dp))
        .fillMaxWidth(0.8f)
        .defaultMinSize(100.dp)
        .height(25.dp)
        .background(MaterialTheme.colorScheme.surface)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Search Notes")
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
        }
    }

}