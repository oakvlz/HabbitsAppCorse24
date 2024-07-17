package com.example.habbitsappcorse24

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.habbitsappcorse24.authentication.domain.usecase.GetUserIdUseCase
import com.example.habbitsappcorse24.onboarding.domain.usecase.HasSeenOnboardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val hasSeenOnboardingUseCase: HasSeenOnboardingUseCase,
    private val getUserIdUseCase: GetUserIdUseCase) : ViewModel(){
    var hasSeenOnboarding by mutableStateOf(hasSeenOnboardingUseCase())
    private set
    var isLoggedIn by mutableStateOf(getUserIdUseCase() != null)
    private set
}