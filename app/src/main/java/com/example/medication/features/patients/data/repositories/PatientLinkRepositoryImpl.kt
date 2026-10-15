package com.example.medication.features.patients.data.repositories

import com.example.medication.features.patients.data.datasources.local.PatientLinkLocalDataSource
import com.example.medication.features.patients.domain.repositories.PatientLinkRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class PatientLinkRepositoryImpl @Inject constructor(
    private val localDataSource: PatientLinkLocalDataSource
) : PatientLinkRepository {

    // TODO: reemplazar por una llamada real a un PatientsApi (Retrofit) / QR cuando exista el backend.
    override suspend fun linkDevice(code: String): Result<String> {
        delay(800)
        val fakePatientId = "patient_$code"
        localDataSource.savePatientId(fakePatientId)
        return Result.success(fakePatientId)
    }

    override fun getLinkedPatientId(): String? = localDataSource.getPatientId()
}