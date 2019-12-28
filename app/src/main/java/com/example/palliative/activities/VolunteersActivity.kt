package com.example.palliative.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.palliative.R
import com.example.palliative.adapters.VolunteerAdapter
import com.example.palliative.models.Volunteerlist
import kotlinx.android.synthetic.main.activity_volunteer.*

class VolunteersActivity : AppCompatActivity() {
    companion object{
        val TAG: String = VolunteersActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volunteer)
    setupRecycleView()




    }
    private fun setupRecycleView(){
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        val adapter= VolunteerAdapter(this, Volunteerlist.volunteers)
        recyclerView.adapter = adapter
    }
}
