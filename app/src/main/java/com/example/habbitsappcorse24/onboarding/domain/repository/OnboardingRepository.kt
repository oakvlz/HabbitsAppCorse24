package com.example.habbitsappcorse24.onboarding.domain.repository

interface OnboardingRepository {
    fun hasSenOnboarding () : Boolean
    fun completeOnBoarding ()
}