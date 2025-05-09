package com.example.lapordesaku

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var namaEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var nomorHpEditText: EditText
    private lateinit var alamatEditText: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        namaEditText = findViewById(R.id.namaEditText)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        nomorHpEditText = findViewById(R.id.nomorHpEditText)
        alamatEditText = findViewById(R.id.alamatEditText)
        registerButton = findViewById(R.id.registerButton)

        registerButton.setOnClickListener {
            val nama = namaEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val nomorHp = nomorHpEditText.text.toString()
            val alamat = alamatEditText.text.toString()

            // Validasi sederhana: pastikan semua field tidak kosong
            if (nama.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && nomorHp.isNotEmpty() && alamat.isNotEmpty()) {
                // Di sini kita akan menyimpan data ke database lokal (Room) nanti
                // Untuk sekarang, kita simulasikan penyimpanan berhasil
                Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()

                // Redirect ke LoginActivity
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Fungsi untuk menyimpan data ke database lokal (akan diimplementasikan dengan Room)
    private fun simpanDataPengguna(nama: String, email: String, password: String, nomorHp: String, alamat: String) {
        // Implementasi penyimpanan data menggunakan Room akan dilakukan nanti
        // Untuk sekarang, kita hanya menampilkan toast berhasil
    }
}