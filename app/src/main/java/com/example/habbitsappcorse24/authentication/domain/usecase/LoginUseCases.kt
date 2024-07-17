package com.example.habbitsappcorse24.authentication.domain.usecase

data class LoginUseCases(
    val loginWithEmailUseCase: LoginWithEmailUseCase,
    val validatePasswordUseCase: ValidatePaswordUseCase,
    val validateEmailUseCase: ValidateEmailUseCase
)
