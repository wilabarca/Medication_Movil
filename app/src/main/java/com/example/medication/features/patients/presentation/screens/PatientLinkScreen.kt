package com.example.medication.features.patients.presentation.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Link
import androidx.compose.material.icons.rounded.Shield
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.medication.R
import com.example.medication.features.patients.presentation.components.CodeInputField
import com.example.medication.features.patients.presentation.viewmodels.PatientLinkViewModel

private val BgTop         = Color(0xFFF1F7F6)
private val BgBottom      = Color(0xFFE9F3FB)
private val TextPrimary   = Color(0xFF0F2A2E)
private val TextSecondary = Color(0xFF64748B)
private val AccentGreen   = Color(0xFF16A34A)
private val IconBgGreen   = Color(0xFFDCFCE7)
private val IconTintGreen = Color(0xFF15803D)
private val ButtonColor   = Color(0xFF0D2A4A)
private val IconBgNeutral = Color(0xFFE7ECF0)

@Composable
fun PatientLinkScreen(
    viewModel: PatientLinkViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onLinkSuccess: (patientId: String) -> Unit,
    onRequestCodeClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(BgTop, BgBottom)))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .padding(top = 24.dp, bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.size(32.dp).background(IconBgNeutral, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = onBackClick, modifier = Modifier.size(32.dp)) {
                        Icon(
                            Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Volver",
                            tint = TextPrimary,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
                Spacer(Modifier.width(8.dp))
                Text("Volver", fontSize = 14.sp, color = TextPrimary)
            }

            Spacer(Modifier.height(24.dp))

            Surface(shape = RoundedCornerShape(20.dp), color = Color.White, shadowElevation = 2.dp) {
                Row(
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.logo_medication),
                        contentDescription = "Logo Medication",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(34.dp).clip(RoundedCornerShape(10.dp))
                    )
                    Text("Medication", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = TextPrimary)
                }
            }

            Spacer(Modifier.height(28.dp))

            Text(
                "Acceso del paciente",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = TextPrimary,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(6.dp))
            Text(
                "Ingresa el código proporcionado por tu cuidador.",
                fontSize = 14.sp,
                color = TextSecondary,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(24.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                color = Color.White,
                shadowElevation = 2.dp
            ) {
                Column(modifier = Modifier.padding(20.dp)) {

                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        Box(
                            modifier = Modifier.size(32.dp).background(IconBgGreen, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Rounded.Link, contentDescription = null, tint = IconTintGreen, modifier = Modifier.size(16.dp))
                        }
                        Text("Vincula este teléfono de manera segura.", fontSize = 13.sp, color = TextSecondary)
                    }

                    Spacer(Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Código de vinculación", fontSize = 13.sp, fontWeight = FontWeight.Medium, color = TextPrimary)
                        Surface(shape = RoundedCornerShape(8.dp), color = IconBgGreen) {
                            Text(
                                "6 CARACTERES",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = IconTintGreen,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }

                    Spacer(Modifier.height(10.dp))

                    CodeInputField(value = uiState.code, onValueChange = viewModel::onCodeChange)

                    Spacer(Modifier.height(10.dp))
                    Text("Escribe el código tal como aparece, sin espacios.", fontSize = 11.sp, color = TextSecondary)

                    uiState.errorMessage?.let { message ->
                        Spacer(Modifier.height(8.dp))
                        Text(message, fontSize = 12.sp, color = Color(0xFFDC2626))
                    }

                    Spacer(Modifier.height(16.dp))

                    Button(
                        onClick = { viewModel.linkDevice(onSuccess = onLinkSuccess) },
                        enabled = uiState.code.length == 6 && !uiState.isLoading,
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = ButtonColor),
                        modifier = Modifier.fillMaxWidth().height(52.dp)
                    ) {
                        if (uiState.isLoading) {
                            CircularProgressIndicator(modifier = Modifier.size(20.dp), color = Color.White, strokeWidth = 2.dp)
                        } else {
                            Text("Vincular dispositivo", fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
                            Spacer(Modifier.width(8.dp))
                            Icon(Icons.Rounded.Link, contentDescription = null, modifier = Modifier.size(16.dp))
                        }
                    }
                }
            }

            Spacer(Modifier.height(18.dp))

            Row {
                Text("¿No tienes un código? ", fontSize = 13.sp, color = TextSecondary)
                Text(
                    "Solicítalo a tu cuidador.",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary,
                    modifier = Modifier.clickable(onClick = onRequestCodeClick)
                )
            }

            Spacer(Modifier.weight(1f))

            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Icon(Icons.Rounded.Shield, contentDescription = null, tint = AccentGreen, modifier = Modifier.size(16.dp))
                Text("La vinculación protege el acceso a tu tratamiento.", fontSize = 12.sp, color = TextSecondary)
            }
        }
    }
}