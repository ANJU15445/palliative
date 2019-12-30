package com.example.palliative.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.palliative.R
import com.example.palliative.adapters.VolunteerAdapter
import com.example.palliative.api.ApiService
import com.example.palliative.models.Volunteerlist
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_volunteer.*

class VolunteersActivity : AppCompatActivity() {
    companion object{
        val TAG: String = VolunteersActivity::class.java.simpleName
    }

    private  val apiService by lazy{
        ApiService.create()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volunteer)
    setupRecycleView()




    }



    fun getVolunteerList(){
        apiService.run{
            volunteerlistview()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        Log.d("Successful Dr Register","response from api ${result}")
                    },
                    { error ->
                        Log.e(
                            "Error", "response from api ${error.localizedMessage  }")
                            }
                )

        }
    }








    private fun setupRecycleView(){
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        val adapter= VolunteerAdapter(this, Volunteerlist.volunteers)

        recyclerView.adapter = adapter
    }
}
