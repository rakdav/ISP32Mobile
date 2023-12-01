package com.example.lab4.view

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.lab4.databinding.ActivityEventBinding

class EventActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btCamera.setOnClickListener {
            startForCamera.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }
        binding.btGalary.setOnClickListener {
            val takePictureIntent = Intent(Intent.ACTION_PICK)
            takePictureIntent.type = "image/*"
            startForGalary.launch(takePictureIntent)
        }
        binding.btOK.setOnClickListener {

        }
    }
    var startForCamera=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result:ActivityResult->
        if(result.resultCode== Activity.RESULT_OK){
            val photo = result.data?.extras?.get("data") as Bitmap
            binding.ImageEvent.setImageBitmap(photo)
        }
    }
    var startForGalary=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result:ActivityResult->
        if(result.resultCode== Activity.RESULT_OK){
            var intent=result.getData();
            if (intent != null) {
                intent.putExtra("content","galery")
            };
            var imageStream = intent?.getData()?.let { contentResolver.openInputStream(it) }
            var selectedImage = BitmapFactory.decodeStream(imageStream)
            binding.ImageEvent.setImageBitmap(selectedImage)
        }
    }
}