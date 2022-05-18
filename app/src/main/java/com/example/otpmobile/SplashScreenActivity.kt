package com.example.otpmobile

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.otpmobile.databinding.ActivitySplashScreenBinding
import com.google.firebase.auth.FirebaseAuth


class SplashScreenActivity: AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        if (currentUser != null){
            Handler().postDelayed({   val i = Intent(this, MainTapActivity::class.java)
                startActivity(i)}, 3000)
        } else {
            Handler().postDelayed({   val i = Intent(this, MainActivity::class.java)
                startActivity(i)}, 3000)
        }

    }
}

