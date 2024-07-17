package com.example.habbitsappcorse24.authentication.presentation.signup

data class SignupState(
    val email : String = "",
    val emailError : String? = null,
    val password : String = "",
    val passwordError : String? = null,
    val isSignedIn : Boolean = false,
    val isLoading : Boolean = false,
    val logIn : Boolean = false
)
