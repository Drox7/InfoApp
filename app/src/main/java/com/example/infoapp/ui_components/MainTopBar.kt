package com.example.infoapp.ui_components

import android.icu.text.CaseMap.Title
import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun MainTopBar(title: String, scaffoldState: ScaffoldState) {
    val coroutine = rememberCoroutineScope()
    TopAppBar(
        title = {
            Text(text = title)
        },
        backgroundColor = Color.White,
        navigationIcon = {
            IconButton(
                onClick = {
                    coroutine.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            ) {
                Icon(imageVector = Icons.Default.Menu,
                    contentDescription ="Menu" )
            }
        },
        actions = {
            IconButton(
                onClick = { 
                    coroutine.launch {

                    }
                }
            ) {
                Icon(imageVector = Icons.Default.Favorite,
                    contentDescription ="Favorite" )
            }
        }
    )
}

@Preview
@Composable
fun PreviewMainTopBar() {
    MainTopBar(title = "Menu test",
        scaffoldState = rememberScaffoldState() )}