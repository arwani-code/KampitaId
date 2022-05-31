package com.picodiploma.kampitaid.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.picodiploma.kampitaid.R
import com.picodiploma.kampitaid.databinding.ActivityScreenBinding

class ScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivityScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnHome.setOnClickListener {
            val intent = Intent(this@ScreenActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}