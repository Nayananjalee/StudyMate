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
        val intent = Intent(this, ToDoHomeActivity::class.java)
        button.setOnClickListener {
            startActivity(intent)
        }

        // Find the ImageView with id imageView10 and set an OnClickListener to start MainActivity4
        val button2 = findViewById<ImageButton>(R.id.imageButton3)
        val intent2 = Intent(this, ChallengeActivity::class.java)
        button2.setOnClickListener {
            startActivity(intent2)
        }

    }
}