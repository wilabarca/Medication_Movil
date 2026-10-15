package com.example.medication.features.auth.data.repositories

import com.example.medication.features.auth.data.datasources.local.RoleLocalDataSource
import com.example.medication.features.auth.domain.entities.UserRole
import com.example.medication.features.auth.domain.repositories.RoleRepository
import javax.inject.Inject

class RoleRepositoryImpl @Inject constructor(
    private val localDataSource: RoleLocalDataSource
) : RoleRepository {

    override fun saveSelectedRole(role: UserRole) {
        localDataSource.saveRole(role)
    }

    override fun getSelectedRole(): UserRole? {
        return localDataSource.getRole()
    }
}