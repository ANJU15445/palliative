package com.example.palliative

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.palliative.api.ApiService
import com.example.palliative.api.Model.PatientRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_patient.*

class Patient : AppCompatActivity() {

    private val apiService by lazy {
        ApiService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient)

        btnPatient.setOnClickListener {

            val strName: String = etName.text.toString()
            val strAddress: String = etAddress.text.toString()
            val strage: String = etAge.text.toString()
            val strphone: String = etPhone.text.toString()
            val strgender: String = etGender.text.toString()
            val strOccupation: String = etOccupation.text.toString()
            val strdisease: String = etDisease.text.toString()
            val strdoctors: String = etDoctorname.text.toString()
            val objRegisterPatient = PatientRequest(
                strName,
                strAddress,
                strage,
                strphone,
                strgender,
                strOccupation,
                strdisease,
                strdoctors
            )
            Toast.makeText(this, "saved ", Toast.LENGTH_SHORT).show()
            apiService.run {
                patientsRegistration(objRegisterPatient)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { result ->
                            //_showLoading.postValue(false)
                            // _showDialog.postValue(true)
                            Log.d("successful registration", "response from api ${result}")
                            // _description.postValue(result.output)
                        },
                        { error ->
                            Log.d("Error", "response from api ${(error.localizedMessage)}")
                            //  _showLoading.postValue(false)
                            // _showDialog.postValue(true)
                            // _description.postValue(error.localizedMessage)
                        }
                    )
            }

        }


    }


}








