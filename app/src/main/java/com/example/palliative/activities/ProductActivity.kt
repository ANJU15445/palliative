package com.example.palliative.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.palliative.adapters.ProductAdapter
import com.example.palliative.R
import com.example.palliative.models.ProductList
import kotlinx.android.synthetic.main.activity_products.*

class ProductActivity : AppCompatActivity() {
    companion object{
        val TAG: String = ProductActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        setupRecyclerView()

    }

    private fun setupRecyclerView(){

        val layoutManager = LinearLayoutManager(this)

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val adapter = ProductAdapter(this, ProductList.products)

         recyclerView.adapter = adapter

    }

}