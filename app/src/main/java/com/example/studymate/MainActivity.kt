package com.example.studymate

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.view.animation.Animation
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load the animation from the XML file
        val animation = AnimationUtils.loadAnimation(this, R.anim.scale_animation)

// Set an animation listener to the animation
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                // Do nothing
            }

            override fun onAnimationEnd(animation: Animation?) {
                // Set the scale of the image view to the final scale value
                val imageView = findViewById<ImageView>(R.id.imageView)
                imageView.scaleX = 1.5f
                imageView.scaleY = 1.5f
            }

            override fun onAnimationRepeat(animation: Animation?) {
                // Do nothing
            }
        })

// Start the animation
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.startAnimation(animation)

        // Animate logo name
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val anim2 = AnimationUtils.loadAnimation(this, R.anim.alpha_animation)
        imageView2.startAnimation(anim2)

        // Wait for 10ms and then navigate to the next activity
        Handler().postDelayed({
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}