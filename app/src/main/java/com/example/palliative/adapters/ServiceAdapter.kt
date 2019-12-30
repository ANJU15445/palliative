package com.example.palliative.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.palliative.R
import com.example.palliative.SERVICE
import com.example.palliative.models.Service
import kotlinx.android.synthetic.main.list_item.view.*

class ServiceAdapter(
    val context: Context,
    val SERVICE: List<Service>
) : RecyclerView.Adapter<ServiceAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return SERVICE.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val SERVICE = SERVICE[position]
        holder.setData(SERVICE, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currentSERVICE: SERVICE? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                Toast.makeText(context,  "${currentSERVICE!!.title }Clicked !", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        fun setData(SERVICE: Service, pos: Int) {
            itemView.txvTitle.text = SERVICE!!.title
            //this.currentSERVICE = Supplier.services
            //this.currentPosition = pos
        }

    }

}
