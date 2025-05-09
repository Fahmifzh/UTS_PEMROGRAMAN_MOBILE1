package com.example.lapordesaku

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TambahPengaduanActivity : AppCompatActivity() {

    private lateinit var judulLaporanEditText: EditText
    private lateinit var kategoriSpinner: Spinner
    private lateinit var deskripsiLaporanEditText: EditText
    private lateinit var kirimButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_pengaduan)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Tambahkan tombol kembali

        judulLaporanEditText = findViewById(R.id.judulLaporanEditText)
        kategoriSpinner = findViewById(R.id.kategoriSpinner)
        deskripsiLaporanEditText = findViewById(R.id.deskripsiLaporanEditText)
        kirimButton = findViewById(R.id.kirimButton)

        // Contoh data kategori (bisa diambil dari resource atau database nanti)
        val kategori = arrayOf("Kebersihan", "Keamanan", "Infrastruktur", "Layanan Publik", "Lain-lain")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, kategori)
        kategoriSpinner.adapter = adapter

        kirimButton.setOnClickListener {
            val judul = judulLaporanEditText.text.toString()
            val kategoriDipilih = kategoriSpinner.selectedItem.toString()
            val deskripsi = deskripsiLaporanEditText.text.toString()

            if (judul.isNotEmpty() && deskripsi.isNotEmpty()) {
                // Di sini kita akan menyimpan data pengaduan ke database lokal (Room) nanti
                Toast.makeText(this, "Laporan terkirim!", Toast.LENGTH_SHORT).show()
                finish() // Kembali ke HomeActivity setelah mengirim
            } else {
                Toast.makeText(this, "Judul dan deskripsi laporan tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Handle tombol kembali di toolbar
        return true
    }
}