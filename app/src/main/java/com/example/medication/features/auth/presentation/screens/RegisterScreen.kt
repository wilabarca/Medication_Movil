package com.example.medication.features.auth.presentation.screens

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.PersonAdd
import androidx.compose.material.icons.rounded.Shield
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material.icons.rounded.VolunteerActivism
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.medication.features.auth.presentation.viewmodels.RegisterViewModel

private val BgTop         = Color(0xFFF1F7F6)
private val BgBottom      = Color(0xFFE9F3FB)
private val TextPrimary   = Color(0xFF0F2A2E)
private val TextSecondary = Color(0xFF64748B)
private val FieldBg       = Color(0xFFF3F6F8)
private val AccentGreen   = Color(0xFF16A34A)
private val IconBgGreen   = Color(0xFFDCFCE7)
private val IconTintGreen = Color(0xFF15803D)
private val ButtonColor   = Color(0xFF0D2A4A)
private val IconBgNeutral = Color(0xFFE7ECF0)

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onRegisterSuccess: () -> Unit,
    onLoginClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    val fieldColors = OutlinedTextFieldDefaults.colors(
        unfocusedContainerColor = FieldBg,
        focusedContainerColor = FieldBg,
        unfocusedBorderColor = Color.Transparent,
        focusedBorderColor = AccentGreen
    )

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

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
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

                Surface(shape = RoundedCornerShape(20.dp), color = IconBgGreen) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(Icons.Rounded.VolunteerActivism, contentDescription = null, tint = IconTintGreen, modifier = Modifier.size(12.dp))
                        Text("SOLO CUIDADOR", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = IconTintGreen)
                    }
                }
            }

            Spacer(Modifier.height(20.dp))

            Text("Crear cuenta", fontWeight = FontWeight.Bold, fontSize = 26.sp, color = TextPrimary)
            Spacer(Modifier.height(6.dp))
            Text(
                "Regístrate para administrar tus pacientes y medicamentos.",
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

                    Text("Nombre", fontSize = 13.sp, fontWeight = FontWeight.Medium, color = TextPrimary)
                    Spacer(Modifier.height(6.dp))
                    OutlinedTextField(
                        value = uiState.name,
                        onValueChange = viewModel::onNameChange,
                        placeholder = { Text("Tu nombre completo") },
                        leadingIcon = { Icon(Icons.Rounded.Person, contentDescription = null, tint = TextSecondary) },
                        singleLine = true,
                        shape = RoundedCornerShape(14.dp),
                        colors = fieldColors,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(14.dp))

                    Text("Correo electrónico", fontSize = 13.sp, fontWeight = FontWeight.Medium, color = TextPrimary)
                    Spacer(Modifier.height(6.dp))
                    OutlinedTextField(
                        value = uiState.email,
                        onValueChange = viewModel::onEmailChange,
                        placeholder = { Text("nombre@correo.com") },
                        leadingIcon = { Icon(Icons.Rounded.Email, contentDescription = null, tint = TextSecondary) },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        shape = RoundedCornerShape(14.dp),
                        colors = fieldColors,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(14.dp))

                    Text("Contraseña", fontSize = 13.sp, fontWeight = FontWeight.Medium, color = TextPrimary)
                    Spacer(Modifier.height(6.dp))
                    OutlinedTextField(
                        value = uiState.password,
                        onValueChange = viewModel::onPasswordChange,
                        placeholder = { Text("••••••••") },
                        leadingIcon = { Icon(Icons.Rounded.Lock, contentDescription = null, tint = TextSecondary) },
                        trailingIcon = {
                            IconButton(onClick = viewModel::onTogglePasswordVisibility) {
                                Icon(
                                    imageVector = if (uiState.isPasswordVisible) Icons.Rounded.VisibilityOff else Icons.Rounded.Visibility,
                                    contentDescription = null,
                                    tint = TextSecondary
                                )
                            }
                        },
                        singleLine = true,
                        visualTransformation = if (uiState.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        shape = RoundedCornerShape(14.dp),
                        colors = fieldColors,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(14.dp))

                    Text("Confirmar contraseña", fontSize = 13.sp, fontWeight = FontWeight.Medium, color = TextPrimary)
                    Spacer(Modifier.height(6.dp))
                    OutlinedTextField(
                        value = uiState.confirmPassword,
                        onValueChange = viewModel::onConfirmPasswordChange,
                        placeholder = { Text("••••••••") },
                        leadingIcon = { Icon(Icons.Rounded.Shield, contentDescription = null, tint = TextSecondary) },
                        trailingIcon = {
                            IconButton(onClick = viewModel::onToggleConfirmPasswordVisibility) {
                                Icon(
                                    imageVector = if (uiState.isConfirmPasswordVisible) Icons.Rounded.VisibilityOff else Icons.Rounded.Visibility,
                                    contentDescription = null,
                                    tint = TextSecondary
                                )
                            }
                        },
                        singleLine = true,
                        visualTransformation = if (uiState.isConfirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        shape = RoundedCornerShape(14.dp),
                        colors = fieldColors,
                        modifier = Modifier.fillMaxWidth()
                    )

                    uiState.errorMessage?.let { message ->
                        Spacer(Modifier.height(8.dp))
                        Text(message, fontSize = 12.sp, color = Color(0xFFDC2626))
                    }

                    Spacer(Modifier.height(16.dp))

                    Button(
                        onClick = { viewModel.register(onSuccess = onRegisterSuccess) },
                        enabled = !uiState.isLoading,
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = ButtonColor),
                        modifier = Modifier.fillMaxWidth().height(52.dp)
                    ) {
                        if (uiState.isLoading) {
                            CircularProgressIndicator(modifier = Modifier.size(20.dp), color = Color.White, strokeWidth = 2.dp)
                        } else {
                            Text("Crear cuenta", fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
                            Spacer(Modifier.width(8.dp))
                            Icon(Icons.Rounded.PersonAdd, contentDescription = null, modifier = Modifier.size(18.dp))
                        }
                    }
                }
            }

            Spacer(Modifier.height(18.dp))

            Row {
                Text("¿Ya tienes una cuenta? ", fontSize = 13.sp, color = TextSecondary)
                Text(
                    "Inicia sesión",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary,
                    modifier = Modifier.clickable(onClick = onLoginClick)
                )
            }
        }
    }
}