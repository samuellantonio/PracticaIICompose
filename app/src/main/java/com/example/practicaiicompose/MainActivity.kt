package com.example.practicaiicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practicaiicompose.ui.theme.PracticaIIComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = { BottomBar(navController) }
            ) { innerPadding ->
                NavHost(
                    navController,
                    startDestination = "form",
                    Modifier.padding(innerPadding)
                ) {
                    composable("form") {
                        FormScreen(navController)
                    }
                    composable("summary?name={name}&age={age}") { backStackEntry ->
                        SummaryScreen(
                            name = backStackEntry.arguments?.getString("name") ?: "",
                            age = backStackEntry.arguments?.getString("age") ?: ""
                        )
                    }
                }
            }
        }
    }
}