package com.example.medication.features.auth.domain.usecases

import com.example.medication.features.auth.domain.entities.UserRole
import com.example.medication.features.auth.domain.repositories.RoleRepository
import javax.inject.Inject

class SaveSelectedRoleUseCase @Inject constructor(
    private val repository: RoleRepository
) {
    operator fun invoke(role: UserRole) {
        repository.saveSelectedRole(role)
    }
}