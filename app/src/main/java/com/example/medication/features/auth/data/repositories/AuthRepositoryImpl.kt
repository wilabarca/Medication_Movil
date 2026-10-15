package com.example.medication.features.auth.data.repositories

import com.example.medication.features.auth.data.datasources.local.SessionLocalDataSource
import com.example.medication.features.auth.domain.repositories.AuthRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sessionLocalDataSource: SessionLocalDataSource
) : AuthRepository {

    // TODO: reemplazar por llamadas reales a un AuthApi (Retrofit) cuando exista el backend.
    // Las firmas de AuthRepository no cambian, así que domain y presentation no se tocan.
    override suspend fun login(email: String, password: String): Result<Unit> {
        delay(800)
        sessionLocalDataSource.saveSession(email)
        return Result.success(Unit)
    }

    override suspend fun register(name: String, email: String, password: String): Result<Unit> {
        delay(800)
        sessionLocalDataSource.saveSession(email)
        return Result.success(Unit)
    }
}