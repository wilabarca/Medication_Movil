
package com.example.medication.features.patients.data.di

import com.example.medication.features.patients.data.repositories.PatientLinkRepositoryImpl
import com.example.medication.features.patients.domain.repositories.PatientLinkRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PatientLinkModule {

    @Binds
    @Singleton
    abstract fun bindPatientLinkRepository(impl: PatientLinkRepositoryImpl): PatientLinkRepository
}