package com.example.brian_nayaka

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class start : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val registerButton = findViewById<Button>(R.id.register)
        val loginButton = findViewById<Button>(R.id.login)

        registerButton.setOnClickListener {
            // Pindah ke layout registrasi atau aktivitas registrasi
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
        loginButton.setOnClickListener {
            // Pindah ke layout registrasi atau aktivitas registrasi
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val googleButton = findViewById<Button>(R.id.googlebutton)

        googleButton.setOnClickListener {
            // Panggil fungsi openGoogle saat tombol diklik
            openGoogle()
        }
    }
    private fun openGoogle() {
        // Tampilkan notifikasi atau pesan toast saat tombol Google diklik
        val message = "Server sedang dalam perawatan"
        showNotification(message)
    }
    @SuppressLint("MissingPermission")
    private fun showNotification(message: String) {
        val notification = NotificationCompat.Builder(this, "channel_id")
            .setSmallIcon(R.drawable.ic_notification) // Gantilah dengan ikon notifikasi yang sesuai
            .setContentTitle("Notifikasi")
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(false) // Notifikasi akan hilang saat ditekan
            .build()

        // Menampilkan notifikasi
        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(1, notification)
    }
}
