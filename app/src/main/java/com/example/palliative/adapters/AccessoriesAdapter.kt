package com.example.palliative.adapters


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.palliative.activities.MainActivity
import com.example.palliative.models.AccessoriesModels
import com.example.palliative.R
import com.example.palliative.models.AccessoriesList.Accessories
import kotlinx.android.synthetic.main.list_view_accessories.view.*

class AccessoriesAdapter (
    val context: Context,
    private val accessories: List<AccessoriesModels>):  RecyclerView.Adapter<AccessoriesAdapter.MyViewHolder>() {

    companion object{
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.list_view_accessories,parent, false)
        // val view =  LayoutInflater.from(context).inflate(R.layout.list_item,parent, attachToRoot:false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {



        return accessories.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val accessories = accessories[position]
        holder.setData(accessories,position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentAccessories: AccessoriesModels? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                currentAccessories?.let {
                    Toast.makeText(context, currentAccessories!!.Name + "Clicked !", Toast.LENGTH_SHORT)
                        .show()

                }
            }


            itemView.setOnClickListener {

                currentAccessories?.let{
                    val message: String = currentAccessories!!.Name + currentAccessories!!

                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT,message)
                    intent.type="text/plain"


                    context.startActivity(Intent.createChooser(intent , "Please select app:"))


                }
            }
        }


        fun setData(accessories: AccessoriesModels, pos:Int) {
            accessories?.let {

                itemView.txvName.text=accessories?.Name


            }
            

            this.currentAccessories = accessories
        }

    }
}



