package com.example.brian_nayaka

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.brian_nayaka.brian_nayaka.other

class SettingActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val homeButton = findViewById<Button>(R.id.homeB)
        val aboutButton = findViewById<Button>(R.id.about)
        val rateButton = findViewById<Button>(R.id.rate)

        homeButton.setOnClickListener {
            val intent = Intent(this, menuutama::class.java)
            startActivity(intent)
        }

        aboutButton.setOnClickListener {
            val intent = Intent(this, Profil::class.java)
            startActivity(intent)
        }

        rateButton.setOnClickListener {
            val intent = Intent(this, other::class.java)
            startActivity(intent)
        }
    }
}