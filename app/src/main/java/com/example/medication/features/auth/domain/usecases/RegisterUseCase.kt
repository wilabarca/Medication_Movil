package com.example.medication.features.auth.domain.usecases

import com.example.medication.features.auth.domain.repositories.AuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Result<Unit> {
        if (name.isBlank()) {
            return Result.failure(IllegalArgumentException("El nombre es obligatorio"))
        }
        if (email.isBlank() || !email.contains("@")) {
            return Result.failure(IllegalArgumentException("Correo inválido"))
        }
        if (password.length < 6) {
            return Result.failure(IllegalArgumentException("La contraseña debe tener al menos 6 caracteres"))
        }
        if (password != confirmPassword) {
            return Result.failure(IllegalArgumentException("Las contraseñas no coinciden"))
        }
        return repository.register(name, email, password)
    }
}