package com.example.brian_nayaka

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class menuutama : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menuutama)

        val penerbanganButton = findViewById<ImageButton>(R.id.penerbangan)
        val hotelTiketButton = findViewById<ImageButton>(R.id.Hoteltiket)
        val otherButton = findViewById<ImageButton>(R.id.Other1)

        penerbanganButton.setOnClickListener {
            val intent = Intent(this, tiketpesawat::class.java) // Ganti dengan aktivitas tujuan Anda
            startActivity(intent)
        }

        hotelTiketButton.setOnClickListener {
            val intent = Intent(this, tikethotel::class.java) // Ganti dengan aktivitas tujuan Anda
            startActivity(intent)
        }

        otherButton.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java) // Ganti dengan aktivitas tujuan Anda
            startActivity(intent)
        }

    }
}