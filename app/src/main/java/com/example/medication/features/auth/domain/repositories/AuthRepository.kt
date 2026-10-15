package com.example.medication.features.auth.domain.repositories

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<Unit>
    suspend fun register(name: String, email: String, password: String): Result<Unit>
}