package com.shazin.remark.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import com.shazin.remark.Routes
import com.shazin.remark.Widgets.NoNoteFound

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navHostController: NavHostController){
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navHostController.navigate(Routes.Writer.path) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        }
    ) {paddingValues ->
        LazyColumn(modifier =
        Modifier
            .fillMaxSize()
            .padding(paddingValues)
        ){
            item {
                HomeHeader(navHostController = navHostController)
            }
        }
    }
}

@Composable
fun HomeHeader(navHostController: NavHostController){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ){
        Text(text = "Notes", style = MaterialTheme.typography.displayLarge)
        Spacer(modifier = Modifier.height(25.dp))
        // Search
        SearchBox()
        NoNoteFound(navHostController = navHostController)
    }
}
@Composable
fun SearchBox(){
    Box(modifier =
    Modifier
        .clip(RoundedCornerShape(25.dp))
        .clickable { }
        .fillMaxWidth(0.8f)
        .defaultMinSize(100.dp)
        .height(40.dp)
        .background(MaterialTheme.colorScheme.surfaceVariant),
        contentAlignment = Alignment.CenterStart
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Search Notes", color = MaterialTheme.colorScheme.onSurfaceVariant)
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon", tint = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }

}

