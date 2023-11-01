package com.example.barmencalc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.SeekBar
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class OrderActivity : AppCompatActivity() {
    private lateinit var order_list:TableLayout
    private lateinit var seek:SeekBar
    private lateinit var tip:TextView
    private lateinit var total:TextView
    private var tips:Double=0.0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        order_list=findViewById(R.id.order_list)
        seek=findViewById(R.id.seek)
        tip=findViewById(R.id.tip)
        total=findViewById(R.id.total)
        val arguments:Bundle=intent.extras!!
        if(arguments!=null)
        {
            var table_number=arguments.getString("table_number")!!
            var listOrders=arguments.getString("orders")
            val typeToken=object :TypeToken<List<Food>>(){}.type
            val orders=Gson().fromJson<List<Food>>(listOrders,typeToken)
            var text:String=table_number
            var sum:Double=0.0
            for(i in orders) {
                var tableRow:TableRow= TableRow(this)

                val textName:TextView= TextView(this)
                textName.textSize = 30.0f
                textName.gravity=Gravity.CENTER
                textName.text=i.food
                tableRow.addView(textName,TableRow.
                LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT,0.5f))

                val textCount:TextView=TextView(this)
                textCount.textSize = 30.0f
                textCount.gravity=Gravity.CENTER
                textCount.text=i.count.toString()
                tableRow.addView(textCount,TableRow.
                LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT,0.5f))

                val textPrice:TextView=TextView(this)
                textPrice.textSize = 30.0f
                textPrice.gravity=Gravity.CENTER
                textPrice.text=i.price.toString()
                tableRow.addView(textPrice,TableRow.
                LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT,0.5f))

                order_list.addView(tableRow)
                sum+=i.count*i.price
            }
            seek.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    tip.text=resources.getString(R.string.tips)+(sum*p1/100).toString()
                    total.text = resources.getString(R.string.total)+(sum+sum*p1/100).toString()
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {

                }

                override fun onStopTrackingTouch(p0: SeekBar?) {

                }

            })
            tip.text=resources.getString(R.string.tips)+tips.toString()
            total.text = resources.getString(R.string.total)+sum.toString()

        }
    }
}