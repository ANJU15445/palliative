package com.example.palliative

import android.app.Service
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.palliative.activities.OnlinePaymentActivity
import com.example.palliative.activities.PaymentActivity
import com.example.palliative.activities.VolunteersActivity
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_transaction.*

class REGISTER : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btnpatient.setOnClickListener {
            val a= Intent(this, PATIENT::class.java)
            startActivity(a)
        }
        btnvolunteer.setOnClickListener{
        val b= Intent(this, VolunteersActivity::class.java)
            startActivity(b)
    }
        btnonlinepayment.setOnClickListener{
          val c= Intent(this,
              OnlinePaymentActivity::class.java)
            startActivity(c)
        }
        btndirectpayment.setOnClickListener {
            val d=Intent(this,
                PaymentActivity::class.java)
            startActivity(d)
        }
//        btnRecyclerViewDemo.setOnClickListener {
//            val intent = Intent(this,Service::class.java)
//            startActivity(intent)
//        }
    }
}
