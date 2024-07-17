package com.example.habbitsappcorse24.authentication.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habbitsappcorse24.authentication.domain.usecase.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class LoginViewModel @Inject constructor(
private val loginUseCases: LoginUseCases): ViewModel(){
    var state by mutableStateOf(LoginState())
    private set

    fun onEvent (event: LoginEvent){
        when (event){
            is LoginEvent.EmailChange -> {
                state = state.copy(
                    email =event.email
                )
            }
            LoginEvent.Login -> {
                login()
            }
            is LoginEvent.PasswordChange -> {
                state = state.copy(
                    password = event.password
                )
            }
        }
    }
    private fun login() {
        state = state.copy(
            emailError = null,
            passwordError = null
        )
        if (!loginUseCases.validateEmailUseCase(state.email)) {
            state = state.copy(
                emailError = " El email no es valido"
            )
        }
        val passworResult = loginUseCases.validatePasswordUseCase(state.password)
        if (passworResult is PassworResult.Invalid) {
            state = state.copy(
                passwordError = passworResult.errorMessage
            )
        }
        if (state.emailError == null && state.passwordError == null) {
            state = state.copy(
                isLoading = true
            )
            viewModelScope.launch {
                loginUseCases.loginWithEmailUseCase(state.email, state.password).onSuccess {
                    state = state.copy(
                        isLoggedIn = true
                    )
                }.onFailure {
                    state = state.copy(
                        emailError = it.message
                    )
                }
                state = state.copy(
                    isLoading = false
                )
            }
        }
    }
}
