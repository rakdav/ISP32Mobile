package com.example.barmencalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var number:EditText
    private lateinit var orders:LinearLayout
    private lateinit var add:FloatingActionButton
    private lateinit var order:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        number=findViewById(R.id.number)
        orders=findViewById(R.id.orders)
        add=findViewById(R.id.fab)
        order=findViewById(R.id.order)
        
    }
}