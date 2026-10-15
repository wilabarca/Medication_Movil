package com.example.medication.features.auth.domain.repositories

import com.example.medication.features.auth.domain.entities.UserRole

interface RoleRepository {
    fun saveSelectedRole(role: UserRole)
    fun getSelectedRole(): UserRole?
}