package com.example.medication.features.auth.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Shield
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import androidx.compose.material.icons.rounded.VolunteerActivism
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Medication
import com.example.medication.R
import com.example.medication.features.auth.presentation.components.RoleOptionCard
import com.example.medication.features.auth.presentation.viewmodels.RoleSelectorViewModel

private val BgTop           = Color(0xFFF1F7F6)
private val BgBottom        = Color(0xFFE9F3FB)
private val TextPrimary     = Color(0xFF0F2A2E)
private val TextSecondary   = Color(0xFF64748B)
private val AccentGreen     = Color(0xFF16A34A)
private val IconBgGreen     = Color(0xFFDCFCE7)
private val IconBgNeutral   = Color(0xFFE7ECF0)
private val IconTintGreen   = Color(0xFF15803D)
private val IconTintNeutral = Color(0xFF475569)

@Composable
fun RoleSelectorScreen(
    viewModel: RoleSelectorViewModel = hiltViewModel(),
    onCaregiverSelected: () -> Unit,
    onPatientSelected: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(BgTop, BgBottom)))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .padding(top = 64.dp, bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Surface(
                shape           = RoundedCornerShape(20.dp),
                color           = Color.White,
                shadowElevation = 2.dp
            ) {
                Row(
                    modifier              = Modifier.padding(horizontal = 24.dp, vertical = 14.dp),
                    verticalAlignment     = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Image(
                        painter            = painterResource(R.drawable.logo_medication),
                        contentDescription = "Logo Medication",
                        contentScale       = ContentScale.Fit,
                        modifier           = Modifier
                            .size(34.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text("Medication", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = TextPrimary)
                }
            }

            Spacer(Modifier.height(40.dp))

            Text(
                "¿Cómo deseas ingresar?",
                fontWeight = FontWeight.Bold,
                fontSize   = 24.sp,
                color      = TextPrimary,
                textAlign  = TextAlign.Center
            )
            Spacer(Modifier.height(6.dp))
            Text(
                "Elige tu perfil para continuar de forma segura.",
                fontSize  = 14.sp,
                color     = TextSecondary,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(28.dp))

            RoleOptionCard(
                title       = "Soy cuidador",
                subtitle    = "Administra pacientes, horarios y medicamentos.",
                icon        = Icons.Rounded.VolunteerActivism,
                iconBg      = IconBgGreen,
                iconTint    = IconTintGreen,
                highlighted = true,
                onClick     = {
                    viewModel.onCaregiverSelected()
                    onCaregiverSelected()
                }
            )

            Spacer(Modifier.height(16.dp))

            RoleOptionCard(
                title       = "Soy paciente",
                subtitle    = "Vincula este dispositivo con el código de tu cuidador.",
                icon        = Icons.Rounded.Person,
                iconBg      = IconBgNeutral,
                iconTint    = IconTintNeutral,
                highlighted = false,
                onClick     = {
                    viewModel.onPatientSelected()
                    onPatientSelected()
                }
            )

            Spacer(Modifier.weight(1f))

            Row(
                verticalAlignment     = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Icon(Icons.Rounded.Shield, contentDescription = null, tint = AccentGreen, modifier = Modifier.size(16.dp))
                Text("Tus datos de salud permanecen protegidos.", fontSize = 12.sp, color = TextSecondary)
            }
        }
    }
}