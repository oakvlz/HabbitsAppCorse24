package com.example.habbitsappcorse24.onboarding.domain.usecase

import com.example.habbitsappcorse24.onboarding.domain.repository.OnboardingRepository

class HasSeenOnboardingUseCase(
    private val repository: OnboardingRepository
) {
    operator fun invoke(): Boolean{
        return  repository.hasSenOnboarding()
    }
}