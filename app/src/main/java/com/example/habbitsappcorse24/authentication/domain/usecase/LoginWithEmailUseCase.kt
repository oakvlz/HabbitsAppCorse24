package com.example.habbitsappcorse24.authentication.domain.usecase

import com.example.habbitsappcorse24.authentication.domain.repository.AuthenticationRepository


class LoginWithEmailUseCase(private val repository: AuthenticationRepository) {
    suspend operator fun invoke(email: String, password: String): Result<Unit> {
        return repository.login(email, password)
    }
}