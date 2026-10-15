package com.example.medication.features.patients.domain.usecases

import com.example.medication.features.patients.domain.repositories.PatientLinkRepository
import javax.inject.Inject

class LinkDeviceUseCase @Inject constructor(
    private val repository: PatientLinkRepository
) {
    suspend operator fun invoke(code: String): Result<String> {
        if (code.length != 6) {
            return Result.failure(IllegalArgumentException("El código debe tener 6 caracteres"))
        }
        return repository.linkDevice(code)
    }
}