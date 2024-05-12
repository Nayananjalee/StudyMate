package com.example.studymate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton



class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Find the ImageView with id imageView6 and set an OnClickListener to start MainActivity5
        val button = findViewById<ImageButton>(R.id.imageButton2)
        val intent = Intent(this, TodayActivity::class.java)
        button.setOnClickListener {
            startActivity(intent)
        }



    }
}