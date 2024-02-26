package com.shazin.remark.Widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun NoNoteFound(navHostController: NavHostController){
    Column {
        Text(text = "No notes found")
        Button(onClick = { /*TODO*/ }) {
            Row {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Create Icon")
                Text(text = "Create")
            }

        }
    }
}