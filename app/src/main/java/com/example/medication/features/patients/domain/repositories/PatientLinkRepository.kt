package com.example.medication.features.patients.domain.repositories

interface PatientLinkRepository {
    suspend fun linkDevice(code: String): Result<String> // retorna el patientId vinculado
    fun getLinkedPatientId(): String?
}