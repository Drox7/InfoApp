package com.example.infoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.infoapp.ui.theme.InfoAppTheme
import com.example.infoapp.ui_components.MainScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            InfoAppTheme {
                MainScreen(context = this)

            }
        }
    }
}


