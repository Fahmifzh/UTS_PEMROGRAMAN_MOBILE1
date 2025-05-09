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

class ListPengaduanActivity : AppCompatActivity() {

    private lateinit var semuaLaporanRecyclerView: RecyclerView
    private lateinit var laporanAdapter: LaporanAdapter
    private lateinit var emptyTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pengaduan)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        semuaLaporanRecyclerView = findViewById(R.id.semuaLaporanRecyclerView)
        emptyTextView = findViewById(R.id.emptyTextView)
        semuaLaporanRecyclerView.layoutManager = LinearLayoutManager(this)

        // Membuat data dummy laporan dari warga lain
        val dummySemuaLaporan = listOf(
            Laporan("Drainase Mampet di RT 02", "Infrastruktur", "Air tidak mengalir lancar setelah hujan deras.", getCurrentDate()),
            Laporan("Ada Keributan di Malam Hari", "Keamanan", "Suara gaduh mengganggu ketenangan warga.", getCurrentDate()),
            Laporan("Jadwal Posyandu Bulan Depan", "Layanan Publik", "Informasi mengenai pelaksanaan Posyandu.", getCurrentDate()),
            Laporan("Lampu Jalan Depan Rumah Mati", "Layanan Publik", "Sudah beberapa hari lampu jalan tidak berfungsi.", getCurrentDate())
            // Tambahkan data dummy lainnya
        )

        if (dummySemuaLaporan.isNotEmpty()) {
            laporanAdapter = LaporanAdapter(dummySemuaLaporan)
            semuaLaporanRecyclerView.adapter = laporanAdapter
            emptyTextView.visibility = View.GONE
            semuaLaporanRecyclerView.visibility = View.VISIBLE
        } else {
            semuaLaporanRecyclerView.visibility = View.GONE
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