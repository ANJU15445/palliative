package com.example.palliative.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.palliative.R
import com.example.palliative.api.ApiService
import com.example.palliative.api.Model.FinalpaymentRequestModels
import com.example.palliative.api.Model.FinalpaymentResponseModels
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_final_payment.*
import retrofit2.http.Body

class FinalPaymentActivity : AppCompatActivity() {


    private val apiService by lazy {
        ApiService.create()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_payment)
        btnSubmit.setOnClickListener {
            val StrContact: String
        }


        fun saveFinalpaymentData() {

            val strName: String = editText.text.toString()
            val objPayRequest= FinalpaymentRequestModels(strName)

            apiService.run {
                finalpaymentlistview(objPayRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { result ->
                            Log.d("Successful Dr Register", "response from api ${result}")
                        },
                        { error ->
                            Log.e(
                                "Error", "response from api ${error.localizedMessage}"
                            )
                        }
                    )

            }
        }
    }
}
