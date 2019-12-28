package com.example.palliative.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.palliative.activities.VolunteersActivity
import com.example.palliative.R
import com.example.palliative.activities.MainActivity
import com.example.palliative.models.VolunteerModel
import kotlinx.android.synthetic.main.list_volunteer.view.*

class VolunteerAdapter(
    val context: Context,
    val volunteers: List<VolunteerModel>
) : RecyclerView.Adapter<VolunteerAdapter.MyViewHolder>() {

    companion object {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VolunteerAdapter.MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_volunteer, parent)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return volunteers.size
    }

    override fun onBindViewHolder(holder: VolunteerAdapter.MyViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}
