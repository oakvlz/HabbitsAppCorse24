package com.example.habbitsappcorse24.onboarding.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.habbitsappcorse24.onboarding.domain.usecase.HasSeenOnboardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val hasSeenOnboardingUSeCase: HasSeenOnboardingUseCase,
    private val compleOnboardingUSeCase: HasSeenOnboardingUseCase

) : ViewModel(){
    var hasSeenOnbaording  by mutableStateOf(hasSeenOnboardingUSeCase())
    private set

    fun completeOnboarding(){
        compleOnboardingUSeCase()
        hasSeenOnbaording = true

    }

}