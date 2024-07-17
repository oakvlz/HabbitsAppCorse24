package com.example.habbitsappcorse24.authentication.data.matcher

import android.util.Patterns
import com.example.habbitsappcorse24.authentication.domain.matcher.EmailMatcher

class EmailMatcherImpl : EmailMatcher {
    override fun isValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}