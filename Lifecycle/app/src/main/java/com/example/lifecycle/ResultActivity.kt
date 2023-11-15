package com.example.lifecycle

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import java.util.Random

class ResultActivity : AppCompatActivity() {
    private var res:Int=0
    private lateinit var first:RadioButton
    private lateinit var second:RadioButton
    private lateinit var third:RadioButton
    private var result:Boolean=false
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        first=findViewById(R.id.first)
        second=findViewById(R.id.second)
        third=findViewById(R.id.third)
        if(intent.extras!=null)
        {
            var x=intent.getIntExtra("x",0)
            var y=intent.getIntExtra("y",0)
            var op=intent.getCharExtra("op",'\u0000')
            when(op)
            {
                '+'->res=x+y
                '-'->res=x-y
                '*'->res=x*y
            }
            first.text=(Random().nextInt(20)-10).toString();
            second.text=(Random().nextInt(20)-10).toString();
            third.text=(Random().nextInt(20)-10).toString();
            var position=Random().nextInt(3)+1
            when(position)
            {
                1->first.text=res.toString()
                2->second.text=res.toString()
                3->third.text=res.toString()
            }
            first.setOnClickListener {
                if(position==1) result=true
                var data=Intent()
                data.putExtra("result",result)
                setResult(RESULT_OK,data)
                finish()
            }
            second.setOnClickListener {
                if(position==2) result=true
                var data=Intent()
                data.putExtra("result",result)
                setResult(RESULT_OK,data)
                finish()
            }
            third.setOnClickListener {
                if(position==3) result=true
                var data=Intent()
                data.putExtra("result",result)
                setResult(RESULT_OK,data)
                finish()
            }

        }
    }
}