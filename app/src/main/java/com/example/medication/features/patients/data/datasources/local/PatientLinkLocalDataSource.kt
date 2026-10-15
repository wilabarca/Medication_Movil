package com.example.medication.features.patients.data.datasources.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PatientLinkLocalDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val prefs = context.getSharedPreferences("patient_link_prefs", Context.MODE_PRIVATE)

    fun savePatientId(patientId: String) {
        prefs.edit().putString(KEY_PATIENT_ID, patientId).apply()
    }

    fun getPatientId(): String? = prefs.getString(KEY_PATIENT_ID, null)

    companion object {
        private const val KEY_PATIENT_ID = "linked_patient_id"
    }
}