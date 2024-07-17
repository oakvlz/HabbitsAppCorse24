package com.example.habbitsappcorse24.authentication.domain.matcher

interface EmailMatcher {
     fun isValid(email: String):Boolean
}