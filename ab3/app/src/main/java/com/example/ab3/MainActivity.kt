package com.example.ab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        var id:Int=item.itemId
        when(id)
        {
            R.id.action_input->{
                var intent=Intent(this,InputActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_calc->{
                var intent=Intent(this,ResultActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_exit->
            {
                this.finish()
                return true
            }
            else->
                return super.onOptionsItemSelected(item);
        }
    }
}