package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.ui.DetailScreen
import com.example.myapplication.ui.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "home") {

                        composable("home") {
                            HomeScreen(
                                onShowClick = { showId ->
                                    navController.navigate("details/$showId")
                                }
                            )
                        }

                        composable(
                            route = "details/{showId}",
                            arguments = listOf(
                                navArgument("showId") { type = NavType.IntType }
                            )
                        ) { backStackEntry ->
                            val showId = backStackEntry.arguments?.getInt("showId") ?: 0

                            // C'EST ICI QUE CA SE JOUE :
                            DetailScreen(
                                showId = showId,
                                onBackClick = {
                                    navController.popBackStack() // Retour à l'écran précédent
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}