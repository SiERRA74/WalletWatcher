package com.example.walletwatcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.walletwatcher.screens.HomeScreen
import com.example.walletwatcher.screens.RecurrentScreen
import com.example.walletwatcher.screens.PonctuelScreen
import com.example.walletwatcher.screens.WishlistScreen
import com.example.walletwatcher.ui.theme.WalletWatcherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WalletWatcherTheme {
                WalletWatcherApp()
            }
        }
    }
}

@Composable
fun WalletWatcherApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(onNavigate = { navController.navigate(it) }) }
        composable("recurrent") { RecurrentScreen() }
        composable("ponctuel") { PonctuelScreen() }
        composable("wishlist") { WishlistScreen() }
    }
}

