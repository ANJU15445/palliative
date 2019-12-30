package com.example.palliative

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.palliative.api.ApiService
import com.example.palliative.api.Model.VolunteerRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_second.*


class VolunteerActivity : AppCompatActivity() {


    private val apiService by lazy {
        ApiService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        btnvolunteer.setOnClickListener {

            val strName: String = etVname.text.toString()
            val strAddress: String = etVaddresss.text.toString()
            val strage: String = etVage.text.toString()
            val strphone: String = etVphone.text.toString()
            val strgender: String = etVgender.text.toString()
            val strOccupation: String = etVoccupation.text.toString()

            val objRegisterVolunteers = VolunteerRequest(
                strName,
                strAddress,
                strage,
                strphone,
                strgender,
                strOccupation

            )
            Toast.makeText(this, "saved ", Toast.LENGTH_SHORT).show()
            apiService.run {
                volunteersRegistration(objRegisterVolunteers)
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
