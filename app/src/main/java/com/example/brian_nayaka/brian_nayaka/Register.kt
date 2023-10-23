package com.example.brian_nayaka

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)

        val registerButton = findViewById<Button>(R.id.registerbutton)


        email.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_NEXT || (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)) {
                password.requestFocus()
                return@setOnEditorActionListener true
            }
            false
        }
        password.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_NEXT || (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)) {
                registerButton.requestFocus()
                return@setOnEditorActionListener true
            }
            false
        }

        registerButton.setOnClickListener {
            val enteredEmail = email.text.toString()
            val enteredPassword = password.text.toString()

            if (enteredEmail.isNotEmpty() && enteredPassword.isNotEmpty()) {
                // Handle the registration process
                // You can add your registration logic here

                // Simpan email dan password ke SharedPreferences
                val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("email", enteredEmail)
                editor.putString("password", enteredPassword)
                editor.apply()

                // After successful registration, you may want to navigate to the login page
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Please fill in all the fields.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
