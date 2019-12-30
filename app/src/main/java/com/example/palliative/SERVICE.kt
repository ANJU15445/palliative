package com.example.palliative

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.palliative.adapters.ServiceAdapter
import com.example.palliative.models.Supplier

class SERVICE : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        val layoutManager=LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val adapter= ServiceAdapter(
            this,
            Supplier.services
        )

    }
}