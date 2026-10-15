package com.example.medication.features.home.presentation.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// Placeholder: cuando exista el feature de medicamentos, este ViewModel pedirá la lista real.
data class PatientHomeUiState(
    val isLinked: Boolean = true
)

@HiltViewModel
class PatientHomeViewModel @Inject constructor() : ViewModel() {
    val uiState = PatientHomeUiState()
}