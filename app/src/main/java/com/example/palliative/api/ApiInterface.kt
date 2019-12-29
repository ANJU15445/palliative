package com.example.palliative.api

import com.example.palliative.api.Model.PatientRequest
import io.reactivex.Observable
import com.example.palliative.api.Model.PatientResponse
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.*

interface ApiInterface {

    @POST("patients")
    fun patientsRegistration(@Body params: PatientRequest): Observable <PatientResponse>

}