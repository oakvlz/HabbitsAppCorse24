package com.example.habbitsappcorse24.onboarding.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.habbitsappcorse24.R
import com.example.habbitsappcorse24.onboarding.presentation.components.OnboardingPager

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel = hiltViewModel(),
    onFinish : () -> Unit
) {
    LaunchedEffect(key1 = viewModel.hasSeenOnbaording ){
        if (viewModel.hasSeenOnbaording){
            onFinish()
        }
    }
    val pages = listOf(
        OnboardingPageInformation(
            title = "Welcome to Monumental Habits",
            subtitle = "We can help yo to be a better version of yourself.",
            image = R.drawable.onboarding1
        ),
        OnboardingPageInformation(
            title = "Create new Habits Easly",
            subtitle = "We can help yo to be a better version of yourself.",
            image = R.drawable.onboarding2
        ),
        OnboardingPageInformation(
            title = "Keep track of our progress",
            subtitle = "We can help yo to be a better version of yourself.",
            image = R.drawable.onboarding3
        ),
        OnboardingPageInformation(
            title = "Join a supportin community",
            subtitle = "We can help yo to be a better version of yourself.",
            image = R.drawable.onboarding4
        )
    )
    OnboardingPager(pages = pages, onFinish = {
        viewModel.completeOnboarding()
    })
}