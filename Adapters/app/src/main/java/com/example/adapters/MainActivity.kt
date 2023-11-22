package com.example.adapters

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
   // var countries = arrayOf("Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай")
    private lateinit var countriesList:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var  countries=resources.getStringArray(R.array.countries)
        countriesList=findViewById(R.id.countriesList)
        val adapter: ArrayAdapter<String?> = ArrayAdapter<String?>(
            this,
            android.R.layout.simple_list_item_1, countries
        )
        countriesList.adapter=adapter
        countriesList.setOnItemClickListener(object: AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val selecteditem=countries[p2]
                Toast.makeText(applicationContext,selecteditem,Toast.LENGTH_LONG).show()
            }

        })
    }
}