package com.example.palliative

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.palliative.activities.ProductActivity
import kotlinx.android.synthetic.main.activity_productimg.*


class Productimg : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productimg)


        btnProduct.setOnClickListener {
            val a= Intent(this, ProductActivity::class.java)
            startActivity(a)


        }

    }


}
