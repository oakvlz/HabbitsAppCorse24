package com.example.habbitsappcorse24.authentication.domain.usecase

import com.example.habbitsappcorse24.authentication.domain.repository.AuthenticationRepository

class GetUserIdUseCase(private val repository: AuthenticationRepository) {
    operator fun invoke(): String?{
        return repository.getUSerId()
    }
}