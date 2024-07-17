package com.example.habbitsappcorse24.authentication.domain.usecase

data class SignupUseCases(
    val signupWithEmailUseCase: SignupWithEmailUseCase,
    val validatePasswordUseCase: ValidatePaswordUseCase,
    val validateEmailUseCase: ValidateEmailUseCase
)
