package com.example.habbitsappcorse24.navigation

sealed class NavigationRoute(val route: String){
    object Onboarding: NavigationRoute("onbording")
    object Login : NavigationRoute("Login")
    object Signup : NavigationRoute("signup")
    object Home : NavigationRoute("home")
}
