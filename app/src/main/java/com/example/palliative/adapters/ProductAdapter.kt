package com.example.palliative.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.palliative.activities.MainActivity
import com.example.palliative.models.ModelsProduct
import com.example.palliative.R
import com.example.palliative.models.ProductList.products
import kotlinx.android.synthetic.main.list_view_product.view.*

class ProductAdapter(
    val context: Context,
    private val producters: List<ModelsProduct>):  RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    companion object{
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.list_view_product,parent, false)
    // val view =  LayoutInflater.from(context).inflate(R.layout.list_item,parent, attachToRoot:false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {


        return products.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val product = products[position]
        holder.setData(product,position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentProduct: ModelsProduct? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                currentProduct?.let {
                    Toast.makeText(context, currentProduct!!.Name + "Clicked !", Toast.LENGTH_SHORT)
                        .show()

                }
            }


            itemView.bgimg.setOnClickListener {

                currentProduct?.let{
                    val message: String = currentProduct!!.Name+currentProduct!!.Price

                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT,message)
                    intent.type="text/plain"


                    context.startActivity(Intent.createChooser(intent , "Please select app:"))


            }
        }
    }


        fun setData(product: ModelsProduct, pos:Int) {
            product?.let {

            itemView.txvName.text=product?.Name


        }

        this.currentProduct = product
        }

    }
}



