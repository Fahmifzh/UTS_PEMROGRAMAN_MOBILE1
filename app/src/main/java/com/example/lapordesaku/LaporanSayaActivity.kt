package com.example.lapordesaku

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class LaporanSayaActivity : AppCompatActivity() {

    private lateinit var laporanRecyclerView: RecyclerView
    private lateinit var laporanAdapter: LaporanAdapter
    private lateinit var emptyTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan_saya)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        laporanRecyclerView = findViewById(R.id.laporanRecyclerView)
        emptyTextView = findViewById(R.id.emptyTextView)
        laporanRecyclerView.layoutManager = LinearLayoutManager(this)

        // Membuat data dummy laporan
        val dummyLaporan = listOf(
            Laporan("Jalan Rusak di Depan Balai Desa", "Infrastruktur", "Kondisi jalan berlubang sangat membahayakan pengguna jalan.", getCurrentDate()),
            Laporan("Sampah Menumpuk di Sungai", "Kebersihan", "Tumpukan sampah menyebabkan bau tidak sedap dan potensi banjir.", getCurrentDate()),
            Laporan("Penerangan Jalan Mati", "Layanan Publik", "Lampu jalan mati membuat lingkungan menjadi gelap di malam hari.", getCurrentDate())
            // Tambahkan data dummy lainnya sesuai kebutuhan
        )

        if (dummyLaporan.isNotEmpty()) {
            laporanAdapter = LaporanAdapter(dummyLaporan)
            laporanRecyclerView.adapter = laporanAdapter
            emptyTextView.visibility = View.GONE
            laporanRecyclerView.visibility = View.VISIBLE
        } else {
            laporanRecyclerView.visibility = View.GONE
            emptyTextView.visibility = View.VISIBLE
        }
    }

    private fun getCurrentDate(): String {
        val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        return sdf.format(Date())
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}