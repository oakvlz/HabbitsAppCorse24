package com.example.habbitsappcorse24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import com.example.habbitsappcorse24.navigation.NavigationHost
import com.example.habbitsappcorse24.navigation.NavigationRoute
import com.example.habbitsappcorse24.ui.theme.HabbitsAppCorse24Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabbitsAppCorse24Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavigationHost(
                        navHostController = navController,
                        startDestination = getStartDestination()
                    )
                    /*
                    *** esta es una forma de usar navigationhost definiendolas , para cuando sean mas pantallas y queres limitar los fallos de direccciones
                    *
                    NavHost(navController= ,startDestination = ){
                        composable("sdfsdf"){

                        }
                        composable(NavigationRoute.Onboarding.route){
                            navcontroller.navigate(NavigationRoute.Onboarding.route)
                        }
                    }*/

                }
            }
        }
    }
    private fun getStartDestination() : NavigationRoute{
        if (viewModel.isLoggedIn){
            return NavigationRoute.Home
        }
        return if (viewModel.hasSeenOnboarding){
            NavigationRoute.Login
        }else{
            NavigationRoute.Onboarding
        }
    }
}

