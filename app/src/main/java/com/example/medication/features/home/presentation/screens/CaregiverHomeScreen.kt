package com.example.medication.features.home.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material.icons.rounded.Groups
import androidx.compose.material.icons.rounded.PersonAdd
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.medication.features.home.presentation.viewmodels.CaregiverHomeViewModel

private val BgTop         = Color(0xFFF1F7F6)
private val BgBottom      = Color(0xFFE9F3FB)
private val TextPrimary   = Color(0xFF0F2A2E)
private val TextSecondary = Color(0xFF64748B)
private val CardBorder    = Color(0xFFE4EAEE)
private val IconBgGreen   = Color(0xFFDCFCE7)
private val IconTintGreen = Color(0xFF15803D)
private val IconBgNeutral = Color(0xFFE7ECF0)

@Composable
fun CaregiverHomeScreen(
    viewModel: CaregiverHomeViewModel = hiltViewModel(),
    onNavigateToPatients: () -> Unit,
    onNavigateToCreatePatient: () -> Unit
) {
    val uiState = viewModel.uiState

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(BgTop, BgBottom)))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .padding(top = 48.dp)
        ) {
            Text("Hola 👋", fontSize = 15.sp, color = TextSecondary)
            Text("¿Qué quieres hacer?", fontWeight = FontWeight.Bold, fontSize = 24.sp, color = TextPrimary)

            Spacer(Modifier.height(28.dp))

            uiState.options.forEach { option ->
                val isPatients = option.id == "patients"
                val icon = if (isPatients) Icons.Rounded.Groups else Icons.Rounded.PersonAdd
                val onClick = if (isPatients) onNavigateToPatients else onNavigateToCreatePatient

                Surface(
                    modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
                    shape = RoundedCornerShape(18.dp),
                    color = Color.White,
                    border = BorderStroke(1.dp, CardBorder),
                    shadowElevation = 1.dp
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Box(
                            modifier = Modifier.size(48.dp).background(IconBgGreen, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(icon, contentDescription = null, tint = IconTintGreen)
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text(option.title, fontWeight = FontWeight.SemiBold, fontSize = 15.sp, color = TextPrimary)
                            Spacer(Modifier.height(2.dp))
                            Text(option.description, fontSize = 12.sp, color = TextSecondary)
                        }
                        Box(
                            modifier = Modifier.size(28.dp).background(IconBgNeutral, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Rounded.ChevronRight, contentDescription = null, tint = TextSecondary, modifier = Modifier.size(16.dp))
                        }
                    }
                }
                Spacer(Modifier.height(14.dp))
            }
        }
    }
}