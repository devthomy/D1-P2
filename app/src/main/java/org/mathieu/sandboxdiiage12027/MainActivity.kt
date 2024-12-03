package org.mathieu.sandboxdiiage12027

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.learnnavigation.PlayerDashboardScreen
import org.mathieu.sandboxdiiage12027.ui.screens.LoginScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.LoginScreen, builder = {
                composable(Routes.LoginScreen){
                    LoginScreen(navController)
                }
                composable(Routes.PlayerDashboard){
                    val name = it.arguments?.getString("name")
                    PlayerDashboardScreen(name?:"No name found")
                }
            })        }
    }
}
