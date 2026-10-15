package com.example.medication.features.auth.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.medication.features.auth.domain.entities.UserRole
import com.example.medication.features.auth.domain.usecases.SaveSelectedRoleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RoleSelectorViewModel @Inject constructor(
    private val saveSelectedRoleUseCase: SaveSelectedRoleUseCase
) : ViewModel() {

    fun onCaregiverSelected() {
        saveSelectedRoleUseCase(UserRole.CAREGIVER)
    }

    fun onPatientSelected() {
        saveSelectedRoleUseCase(UserRole.PATIENT)
    }
}