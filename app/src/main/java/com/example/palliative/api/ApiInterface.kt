package com.example.palliative.api

import com.example.palliative.api.Model.PatientRequest
import io.reactivex.Observable
import com.example.palliative.api.Model.PatientResponse
import com.example.palliative.api.Model.VolunteerRequest
import com.example.palliative.api.Model.VolunteerResponse
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.*

interface ApiInterface {

    @POST("patients")
    fun patientsRegistration(@Body params: PatientRequest): Observable <PatientResponse>


@POST("Volunteer")
fun volunteersRegistration(@Body params: VolunteerRequest): Observable <VolunteerResponse>

}