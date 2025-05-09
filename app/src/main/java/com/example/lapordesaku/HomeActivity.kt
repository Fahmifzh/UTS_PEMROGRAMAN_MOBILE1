package com.example.lapordesaku


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {

    private lateinit var tambahPengaduanCard: CardView
    private lateinit var laporanSayaCard: CardView
    private lateinit var listPengaduanCard: CardView
    private lateinit var chatWargaCard: CardView
    private lateinit var tentangAplikasiCard: CardView
    // private lateinit var logoutCard: CardView // Jika ada menu Logout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        tambahPengaduanCard = findViewById(R.id.tambahPengaduanCard)
        laporanSayaCard = findViewById(R.id.laporanSayaCard)
        listPengaduanCard = findViewById(R.id.listPengaduanCard)
        chatWargaCard = findViewById(R.id.chatWargaCard)
        tentangAplikasiCard = findViewById(R.id.tentangAplikasiCard)
        // logoutCard = findViewById(R.id.logoutCard) // Jika ada menu Logout

        tambahPengaduanCard.setOnClickListener {
            startActivity(Intent(this, TambahPengaduanActivity::class.java))
        }

        laporanSayaCard.setOnClickListener {
            startActivity(Intent(this, LaporanSayaActivity::class.java))
        }

        listPengaduanCard.setOnClickListener {
            startActivity(Intent(this, ListPengaduanActivity::class.java))
        }

        chatWargaCard.setOnClickListener {
            startActivity(Intent(this, ChatWargaActivity::class.java))
        }

        tentangAplikasiCard.setOnClickListener {
            startActivity(Intent(this, TentangAplikasiActivity::class.java))
        }

        // Jika ada menu Logout
        /*logoutCard.setOnClickListener {
            // Implementasikan logika logout di sini
            // Contoh: menghapus sesi login dan kembali ke LoginActivity
            val sharedPreferences = getSharedPreferences("login_session", MODE_PRIVATE)
            sharedPreferences.edit().clear().apply()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }*/
    }
}