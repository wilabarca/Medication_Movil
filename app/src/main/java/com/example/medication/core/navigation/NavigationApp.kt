package com.example.medication.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.medication.features.auth.presentation.screens.LoginScreen
import com.example.medication.features.auth.presentation.screens.RegisterScreen
import com.example.medication.features.auth.presentation.screens.RoleSelectorScreen
import com.example.medication.features.home.presentation.screens.CaregiverHomeScreen
import com.example.medication.features.home.presentation.screens.PatientHomeScreen
import com.example.medication.features.patients.presentation.screens.PatientLinkScreen

@Composable
fun NavigationApp(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Routes.ROLE_SELECTOR) {

        composable(Routes.ROLE_SELECTOR) {
            RoleSelectorScreen(
                onCaregiverSelected = { navController.navigate(Routes.LOGIN) },
                onPatientSelected = { navController.navigate(Routes.PATIENT_LINK) }
            )
        }

        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.CAREGIVER_HOME) {
                        popUpTo(Routes.ROLE_SELECTOR) { inclusive = false }
                    }
                },
                onForgotPasswordClick = { /* TODO: pantalla de recuperación, aún sin mockup */ },
                onRegisterClick = { navController.navigate(Routes.REGISTER) }
            )
        }

        composable(Routes.REGISTER) {
            RegisterScreen(
                onBackClick = { navController.popBackStack() },
                onRegisterSuccess = {
                    navController.navigate(Routes.CAREGIVER_HOME) {
                        popUpTo(Routes.ROLE_SELECTOR) { inclusive = false }
                    }
                },
                onLoginClick = { navController.popBackStack() }
            )
        }

        composable(Routes.PATIENT_LINK) {
            PatientLinkScreen(
                onBackClick = { navController.popBackStack() },
                onLinkSuccess = {
                    navController.navigate(Routes.PATIENT_HOME) {
                        popUpTo(Routes.ROLE_SELECTOR) { inclusive = false }
                    }
                },
                onRequestCodeClick = { /* TODO: flujo "solicitar código", aún sin definir */ }
            )
        }

        composable(Routes.CAREGIVER_HOME) {
            CaregiverHomeScreen(
                onNavigateToPatients = { /* TODO: lista de pacientes */ },
                onNavigateToCreatePatient = { /* TODO: crear paciente */ }
            )
        }

        composable(Routes.PATIENT_HOME) {
            PatientHomeScreen()
        }
    }
}