package com.example.medication.features.auth.data.di

import com.example.medication.features.auth.data.repositories.RoleRepositoryImpl
import com.example.medication.features.auth.domain.repositories.RoleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RoleModule {

    @Binds
    @Singleton
    abstract fun bindRoleRepository(
        impl: RoleRepositoryImpl
    ): RoleRepository
}