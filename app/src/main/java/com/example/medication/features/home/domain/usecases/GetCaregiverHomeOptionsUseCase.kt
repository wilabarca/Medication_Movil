package com.example.medication.features.home.domain.usecases

import com.example.medication.features.home.domain.entities.CaregiverMenuItem
import javax.inject.Inject

class GetCaregiverHomeOptionsUseCase @Inject constructor() {
    operator fun invoke(): List<CaregiverMenuItem> = listOf(
        CaregiverMenuItem(
            id = "patients",
            title = "Pacientes",
            description = "Ver y administrar tus pacientes vinculados"
        ),
        CaregiverMenuItem(
            id = "create_patient",
            title = "Agregar paciente",
            description = "Registrar un nuevo paciente y generar su código"
        )
    )
}