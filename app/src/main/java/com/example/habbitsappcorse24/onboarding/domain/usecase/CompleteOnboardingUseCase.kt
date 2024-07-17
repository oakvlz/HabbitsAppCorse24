package com.example.habbitsappcorse24.onboarding.domain.usecase

import com.example.habbitsappcorse24.onboarding.domain.repository.OnboardingRepository

class CompleteOnboardingUseCase (
    private val repository: OnboardingRepository
) {
    operator fun invoke(){
          repository.completeOnBoarding()
    }
}