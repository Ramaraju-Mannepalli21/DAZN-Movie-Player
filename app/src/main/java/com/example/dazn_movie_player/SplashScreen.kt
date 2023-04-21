package com.example.dazn_movie_player

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val handler = Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, VideoStreaming::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}