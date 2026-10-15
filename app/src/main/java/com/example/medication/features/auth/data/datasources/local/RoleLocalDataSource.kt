package com.example.medication.features.auth.data.datasources.local

import android.content.Context
import com.example.medication.features.auth.domain.entities.UserRole
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class RoleLocalDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val prefs = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

    fun saveRole(role: UserRole) {
        prefs.edit().putString(KEY_ROLE, role.name).apply()
    }

    fun getRole(): UserRole? {
        val value = prefs.getString(KEY_ROLE, null) ?: return null
        return runCatching { UserRole.valueOf(value) }.getOrNull()
    }

    companion object {
        private const val KEY_ROLE = "selected_role"
    }
}