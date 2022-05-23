package com.example.otpmobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.otpmobile.databinding.ActivityBrandDetailBinding



class BrandDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBrandDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBrandDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}