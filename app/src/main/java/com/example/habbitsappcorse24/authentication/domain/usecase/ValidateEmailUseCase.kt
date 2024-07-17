package com.example.habbitsappcorse24.authentication.domain.usecase

import android.util.Patterns
import com.example.habbitsappcorse24.authentication.domain.matcher.EmailMatcher

class ValidateEmailUseCase( private val emailMatcher: EmailMatcher) {
    operator  fun invoke (email: String): Boolean{
        return emailMatcher.isValid(email)
    }
}