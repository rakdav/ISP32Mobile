package com.example.barmencalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var number:EditText
    private lateinit var orders:LinearLayout
    private lateinit var add:FloatingActionButton
    private lateinit var order:Button
    private var count:Int=0
    private lateinit var views:MutableList<View>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        number=findViewById(R.id.number)
        orders=findViewById(R.id.orders)
        add=findViewById(R.id.fab)
        order=findViewById(R.id.order)
        views= mutableListOf()
        add.setOnClickListener(View.OnClickListener {
            count++;

            val view:View=layoutInflater.inflate(R.layout.order_item,null)
            var foot:EditText=view.findViewById(R.id.foot)
            var count:EditText=view.findViewById(R.id.count)
            var price:EditText=view.findViewById(R.id.price)
            var del:Button=view.findViewById(R.id.del)
            del.setOnClickListener(View.OnClickListener {
                try {
                    (view.parent as LinearLayout).removeView(view)
                    views.remove(view)
                }
                catch (ex:Exception)
                {
                    Log.d("root",ex.message!!)
                }

            })
            views.add(view)
            orders.addView(view)
        })
        order.setOnClickListener(View.OnClickListener {
            var foods:MutableList<Food> = mutableListOf()
            for (i in views)
            {
                val name=(i.findViewById(R.id.foot) as EditText).text.toString()
                val count=(i.findViewById(R.id.count) as EditText).text.toString().toInt()
                val price=(i.findViewById(R.id.price) as EditText).text.toString().toDouble()
                var food:Food=Food(name,count,price)
                foods.add(food)
            }
            val intent:Intent= Intent(applicationContext,OrderActivity::class.java)
            intent.putExtra("table_number",number.text.toString())
            var ordersGson=Gson().toJson(foods)
            intent.putExtra("orders",ordersGson)
            startActivity(intent)
        })
    }
}