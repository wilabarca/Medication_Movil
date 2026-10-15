package com.example.medication.features.home.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.medication.features.home.domain.entities.CaregiverMenuItem
import com.example.medication.features.home.domain.usecases.GetCaregiverHomeOptionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class CaregiverHomeUiState(
    val options: List<CaregiverMenuItem> = emptyList()
)

@HiltViewModel
class CaregiverHomeViewModel @Inject constructor(
    getCaregiverHomeOptionsUseCase: GetCaregiverHomeOptionsUseCase
) : ViewModel() {

    val uiState = CaregiverHomeUiState(options = getCaregiverHomeOptionsUseCase())
}