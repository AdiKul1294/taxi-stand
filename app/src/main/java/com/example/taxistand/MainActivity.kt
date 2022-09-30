package com.example.taxistand

import android.hardware.camera2.params.SessionConfiguration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taxistand.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

    }

}