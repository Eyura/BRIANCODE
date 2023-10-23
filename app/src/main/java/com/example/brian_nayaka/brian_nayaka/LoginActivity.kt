package com.example.brian_nayaka

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val enteredEmail = email.text.toString()
            val enteredPassword = password.text.toString()

            if (enteredEmail.isNotEmpty() && enteredPassword.isNotEmpty()) {
                if (isLoginValid(enteredEmail, enteredPassword)) {
                    // Login berhasil, arahkan ke halaman menu.
                    val intent = Intent(this@LoginActivity, menuutama::class.java)
                    startActivity(intent)
                    finish() // Optional: Tutup halaman login.
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Login gagal. Cek kembali email dan password Anda.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    this@LoginActivity,
                    "Isi email dan password terlebih dahulu.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Tambahkan aksi saat "Enter" pada keyboard ditekan di EditText email
        email.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_NEXT || (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)) {
                // Fokus ke EditText password ketika "Enter" ditekan
                password.requestFocus()
                true
            } else {
                false
            }
        }

        // Tambahkan aksi saat "Enter" pada keyboard ditekan di EditText password
        password.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE || (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)) {
                // Aksi yang akan diambil ketika "Enter" ditekan pada EditText password
                // Misalnya, jalankan login
                loginButton.requestFocus()
                true
            } else {
                false
            }
        }
    }

    private fun isLoginValid(enteredEmail: String, enteredPassword: String): Boolean {
        val sharedPref = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val savedEmail = sharedPref.getString("email", "")
        val savedPassword = sharedPref.getString("password", "")
        Log.d("SharedPreferences", "Saved Email: $savedEmail")
        Log.d("SharedPreferences", "Saved Password: $savedPassword")
        return enteredEmail == savedEmail && enteredPassword == savedPassword
    }

}
