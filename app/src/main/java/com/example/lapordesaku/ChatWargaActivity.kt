package com.example.lapordesaku


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ChatWargaActivity : AppCompatActivity() {

    private lateinit var chatRecyclerView: RecyclerView
    private lateinit var pesanAdapter: PesanAdapter
    private lateinit var messageEditText: EditText
    private lateinit var sendButton: Button
    private val listPesan = mutableListOf<Pesan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_warga)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        chatRecyclerView = findViewById(R.id.chatRecyclerView)
        messageEditText = findViewById(R.id.messageEditText)
        sendButton = findViewById(R.id.sendButton)

        chatRecyclerView.layoutManager = LinearLayoutManager(this)
        pesanAdapter = PesanAdapter(listPesan)
        chatRecyclerView.adapter = pesanAdapter

        // Tambahkan beberapa pesan dummy
        listPesan.add(Pesan("Warga 1", "Halo semua!", getCurrentTime()))
        listPesan.add(Pesan("Warga 2", "Hai!", getCurrentTime()))
        listPesan.add(Pesan("Warga 1", "Ada info terbaru kah?", getCurrentTime()))
        pesanAdapter.notifyDataSetChanged()
        chatRecyclerView.scrollToPosition(listPesan.size - 1) // Scroll ke pesan terakhir

        sendButton.setOnClickListener {
            val message = messageEditText.text.toString().trim()
            if (message.isNotEmpty()) {
                // Di sini kita akan menyimpan pesan ke database lokal (Room) dan mengirimkannya (jika ada fitur online)
                val newMessage = Pesan("Anda", message, getCurrentTime())
                listPesan.add(newMessage)
                pesanAdapter.notifyItemInserted(listPesan.size - 1)
                messageEditText.text.clear()
                chatRecyclerView.scrollToPosition(listPesan.size - 1)
            }
        }
    }

    private fun getCurrentTime(): String {
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        return sdf.format(Date())
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}