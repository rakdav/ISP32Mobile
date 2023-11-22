package com.example.testprojectisp32

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var var1:EditText
    private lateinit var var2:EditText
    private lateinit var buttonAdd: Button
    private lateinit var buttonSub: Button
    private lateinit var buttonMult: Button
    private lateinit var buttonDiv: Button
    private lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var1=findViewById(R.id.var1)
        var2=findViewById(R.id.var2)
        buttonAdd=findViewById(R.id.add)
        buttonSub=findViewById(R.id.sub)
        buttonMult=findViewById(R.id.mult)
        buttonDiv=findViewById(R.id.div)
        result=findViewById(R.id.result)
        buttonAdd.setOnClickListener {
            var calculator:Calculator=Calculator(var1.text.toString().toInt(),
                var2.text.toString().toInt())
            result.text=calculator.Add().toString()
        }
    }
}