package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show()
        super.onStart()

    }

    override fun onResume() {
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show()
        super.onResume()

    }

    override fun onPause() {
        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show()
        super.onPause()
    }

    override fun onStop() {
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show()
        super.onStop()
    }

    override fun onRestart() {
        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show()
        super.onRestart()
    }

    override fun onDestroy() {
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }
}