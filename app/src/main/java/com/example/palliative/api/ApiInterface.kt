package com.example.palliative.api

import com.example.palliative.api.Model.*
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.*

interface ApiInterface {

    @POST("patients")
    fun patientsRegistration(@Body params: PatientRequest): Observable<PatientResponse>

    @GET("getVolunteersData")
    fun volunteerlistview():Observable<VolunteerslistviewModels>

    @POST("saveFinalPaymentData")
    fun finalpaymentlistview(@Body params: FinalpaymentRequestModels):Observable<FinalpaymentResponseModels>


}