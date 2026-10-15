package com.example.medication.features.home.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.medication.features.home.presentation.viewmodels.PatientHomeViewModel

private val BgTop         = Color(0xFFF1F7F6)
private val BgBottom      = Color(0xFFE9F3FB)
private val TextPrimary   = Color(0xFF0F2A2E)
private val TextSecondary = Color(0xFF64748B)

@Composable
fun PatientHomeScreen(
    viewModel: PatientHomeViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(BgTop, BgBottom))),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if (uiState.isLinked) {
                Text("Dispositivo vinculado", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = TextPrimary)
                Text("Aquí irá tu lista de medicamentos", fontSize = 13.sp, color = TextSecondary)
            } else {
                Text("Aún no estás vinculado", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = TextPrimary)
                Text("Pide el código a tu cuidador para continuar", fontSize = 13.sp, color = TextSecondary)
            }
        }
    }
}