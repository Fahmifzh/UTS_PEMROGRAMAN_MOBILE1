package com.example.lapordesaku


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LaporanAdapter(private val listLaporan: List<Laporan>) :
    RecyclerView.Adapter<LaporanAdapter.LaporanViewHolder>() {

    class LaporanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val judulTextView: TextView = itemView.findViewById(R.id.judulTextView)
        val kategoriTextView: TextView = itemView.findViewById(R.id.kategoriTextView)
        val deskripsiTextView: TextView = itemView.findViewById(R.id.deskripsiTextView)
        val tanggalTextView: TextView = itemView.findViewById(R.id.tanggalTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaporanViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_laporan, parent, false)
        return LaporanViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LaporanViewHolder, position: Int) {
        val currentItem = listLaporan[position]
        holder.judulTextView.text = currentItem.judul
        holder.kategoriTextView.text = currentItem.kategori
        holder.deskripsiTextView.text = currentItem.deskripsi
        holder.tanggalTextView.text = currentItem.tanggal
    }

    override fun getItemCount() = listLaporan.size
}