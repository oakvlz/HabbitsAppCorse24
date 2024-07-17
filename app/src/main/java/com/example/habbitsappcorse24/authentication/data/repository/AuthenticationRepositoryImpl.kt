package com.example.habbitsappcorse24.authentication.data.repository

import com.example.habbitsappcorse24.authentication.domain.repository.AuthenticationRepository
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class AuthenticationRepositoryImpl : AuthenticationRepository {
    override suspend fun login(email: String, password: String): Result<Unit> {
        return try {
                Firebase.auth.signInWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: Exception){
             Result.failure(e)
        }
    }

    override suspend fun signup(email: String, password: String): Result<Unit> {
        return try {
            Firebase.auth.createUserWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    override fun getUSerId(): String? {
        return Firebase.auth.currentUser?.uid
    }
}