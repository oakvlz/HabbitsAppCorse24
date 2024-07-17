package com.example.habbitsappcorse24.authentication.di

import com.example.habbitsappcorse24.authentication.data.matcher.EmailMatcherImpl
import com.example.habbitsappcorse24.authentication.data.repository.AuthenticationRepositoryImpl
import com.example.habbitsappcorse24.authentication.domain.matcher.EmailMatcher
import com.example.habbitsappcorse24.authentication.domain.repository.AuthenticationRepository
import com.example.habbitsappcorse24.authentication.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AuthenticationModule {
    @Provides
    @Singleton
    fun provideAuthenticationRepository():AuthenticationRepository {
        return AuthenticationRepositoryImpl()
    }
    @Provides
    @Singleton
    fun ProvideEmailMatcher():EmailMatcher{
        return EmailMatcherImpl()
    }
    @Provides
    @Singleton
    fun provideSignupUseCases(
        repository: AuthenticationRepository,
        emailMatcher: EmailMatcher
    ): SignupUseCases {
        return SignupUseCases(
            signupWithEmailUseCase = SignupWithEmailUseCase(repository),
            validateEmailUseCase = ValidateEmailUseCase(emailMatcher),
            validatePasswordUseCase = ValidatePaswordUseCase()
        )
    }
    @Provides
    @Singleton
    fun provideLoginUseCases( repository: AuthenticationRepository , emailMatcher: EmailMatcher): LoginUseCases{
        return LoginUseCases(
            loginWithEmailUseCase = LoginWithEmailUseCase(repository ),
            validateEmailUseCase =  ValidateEmailUseCase(emailMatcher),
            validatePasswordUseCase = ValidatePaswordUseCase()
        )
    }
    @Provides
    @Singleton
    fun provideGetUserIdUseCase(repository: AuthenticationRepository):GetUserIdUseCase{
        return GetUserIdUseCase(repository)
    }
}