package com.example.medication.features.patients.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medication.features.patients.domain.usecases.LinkDeviceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PatientLinkUiState(
    val code: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

@HiltViewModel
class PatientLinkViewModel @Inject constructor(
    private val linkDeviceUseCase: LinkDeviceUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(PatientLinkUiState())
    val uiState: StateFlow<PatientLinkUiState> = _uiState.asStateFlow()

    fun onCodeChange(value: String) {
        val cleaned = value.uppercase().filter { it.isLetterOrDigit() }.take(6)
        _uiState.value = _uiState.value.copy(code = cleaned, errorMessage = null)
    }

    fun linkDevice(onSuccess: (patientId: String) -> Unit) {
        val code = _uiState.value.code
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)
            linkDeviceUseCase(code)
                .onSuccess { patientId ->
                    _uiState.value = _uiState.value.copy(isLoading = false)
                    onSuccess(patientId)
                }
                .onFailure { error ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = error.message ?: "Código inválido"
                    )
                }
        }
    }
}