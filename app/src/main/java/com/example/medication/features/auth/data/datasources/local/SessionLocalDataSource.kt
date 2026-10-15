package com.example.medication.features.auth.data.datasources.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SessionLocalDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val prefs = context.getSharedPreferences("session_prefs", Context.MODE_PRIVATE)

    fun saveSession(email: String) {
        prefs.edit().putString(KEY_EMAIL, email).apply()
    }

    fun isLoggedIn(): Boolean = prefs.contains(KEY_EMAIL)

    companion object {
        private const val KEY_EMAIL = "logged_in_email"
    }
}