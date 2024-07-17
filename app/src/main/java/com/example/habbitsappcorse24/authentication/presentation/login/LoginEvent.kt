package com.example.habbitsappcorse24.authentication.presentation.login

interface LoginEvent {

    data class EmailChange(val email : String) : LoginEvent
    data class PasswordChange(val password : String) : LoginEvent
    object Login : LoginEvent

}