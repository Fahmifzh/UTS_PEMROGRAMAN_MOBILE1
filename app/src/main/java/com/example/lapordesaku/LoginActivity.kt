package com.example.lapordesaku

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        registerTextView = findViewById(R.id.registerTextView)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Untuk sementara, kita simulasikan login berhasil jika email dan password tidak kosong
            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Simpan sesi login (implementasi sederhana, bisa menggunakan SharedPreferences)
                // Misalnya: saveLoginSession(email)

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish() // Agar tidak bisa kembali ke halaman login dengan tombol back
            } else {
                Toast.makeText(this, "Email dan password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }

        registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    // Fungsi simulasi penyimpanan sesi login (nanti akan diimplementasikan dengan lebih baik)
    private fun saveLoginSession(email: String) {
        // Implementasi penyimpanan sesi seperti menggunakan SharedPreferences
        // Contoh sederhana:
        val sharedPreferences = getSharedPreferences("login_session", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("user_email", email)
        editor.apply()
    }
}