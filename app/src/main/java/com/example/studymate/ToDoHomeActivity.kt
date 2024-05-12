package com.example.studymate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import com.example.nexttodo.R

class ToDoHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.to_do_home)


        // Find the ImageView with id imageView6 and set an OnClickListener to start MainActivity5
        val button = findViewById<ImageView>(R.id.imageView6)
        val intent = Intent(this, InboxActivity::class.java)
        button.setOnClickListener {
            startActivity(intent)
        }

        // Find the ImageView with id imageView10 and set an OnClickListener to start MainActivity4
        val button2 = findViewById<ImageView>(R.id.imageView7)
        val intent2 = Intent(this, TodayActivity::class.java)
        button2.setOnClickListener {
            startActivity(intent2)
        }
        // Find the ImageView with id imageView10 and set an OnClickListener to start MainActivity4
        val button3 = findViewById<ImageView>(R.id.imageView8)
        val intent3 = Intent(this, UpcomingActivity::class.java)
        button3.setOnClickListener {
            startActivity(intent3)
        }
    }
}