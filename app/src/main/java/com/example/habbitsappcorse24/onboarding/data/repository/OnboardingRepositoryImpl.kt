package com.example.habbitsappcorse24.onboarding.data.repository

import android.content.SharedPreferences
import com.example.habbitsappcorse24.onboarding.domain.repository.OnboardingRepository

class OnboardingRepositoryImpl(
    private val sharedPreferences: SharedPreferences
) : OnboardingRepository {

    companion object {
        private const val HAS_SEEN_ONBOARDING = "has_seen_onboarding"
    }

    override fun hasSenOnboarding(): Boolean {
        return sharedPreferences.getBoolean(HAS_SEEN_ONBOARDING, false)
    }

    override fun completeOnBoarding() {
        sharedPreferences.edit().putBoolean(HAS_SEEN_ONBOARDING, true).apply()
    }
}