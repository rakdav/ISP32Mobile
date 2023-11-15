package com.example.lifecycle

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var expession:TextView
    private lateinit var watch:Button
    private lateinit var next:Button
    private var x:Int = 0
    private var y:Int = 0
    private var op:Char = '\u0000'
    override fun onCreate(savedInstanceState: Bundle?) {
        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        expession=findViewById(R.id.expression)
        watch=findViewById(R.id.watch)
        next=findViewById(R.id.next)
    }

    override fun onStart() {
        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show()
        super.onStart()
        next.visibility=View.INVISIBLE
        x=Random().nextInt(10) + 1
        y=Random().nextInt(10)+1
        var operation:Int=Random().nextInt(3)+1
        when(operation)
        {
            1 -> op='+'
            2 -> op='-'
            3 -> op='*'
        }
        expession.text="${x}${op}${y}"
        watch.setOnClickListener {
            var intent=Intent(applicationContext,ResultActivity::class.java)
            intent.putExtra("x",x)
            intent.putExtra("y",y)
            when(op)
            {
                '+'->intent.putExtra("op",'+')
                '-'->intent.putExtra("op",'-')
                '*'->intent.putExtra("op",'*')
            }
            startForResult.launch(intent)
        }
    }

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            var res=intent!!.getBooleanExtra("result",false)
            if(res) watch.setBackgroundColor(Color.GREEN)
            else watch.setBackgroundColor(Color.RED)
        }
    }
    @SuppressLint("SetTextI18n")
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