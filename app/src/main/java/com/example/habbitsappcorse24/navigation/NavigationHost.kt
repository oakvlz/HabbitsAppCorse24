package com.example.habbitsappcorse24.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.habbitsappcorse24.authentication.presentation.login.LoginScreen
import com.example.habbitsappcorse24.authentication.presentation.signup.SignupScreen
import com.example.habbitsappcorse24.home.presentation.home.HomeScreen
import com.example.habbitsappcorse24.onboarding.presentation.OnboardingScreen

@Composable
fun NavigationHost(
    navHostController: NavHostController,
    startDestination: NavigationRoute
) {
    NavHost(navController = navHostController, startDestination = startDestination.route) {
        composable(NavigationRoute.Onboarding.route) {
            OnboardingScreen(
                onFinish = {
                    navHostController.popBackStack()
                    navHostController.navigate(NavigationRoute.Login.route)
                }
            )
        }
        composable(NavigationRoute.Login.route) {
            LoginScreen(onLogin = {
                navHostController.popBackStack()
                navHostController.navigate(NavigationRoute.Home.route)
            }, onSignup = {
                navHostController.navigate(NavigationRoute.Signup.route)
            })
        }

        composable(NavigationRoute.Signup.route) {
            SignupScreen(onSignIn = {
                navHostController.navigate(NavigationRoute.Home.route){
                    popUpTo(navHostController.graph.id){
                        inclusive = true
                    }
                }

            }, onLogin = {
                navHostController.popBackStack()
            })
        }

        composable(NavigationRoute.Home.route) {
            HomeScreen()
        }
    }
}