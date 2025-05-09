package com.example.lapordesaku

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PesanAdapter(private val listPesan: List<Pesan>) :
    RecyclerView.Adapter<PesanAdapter.PesanViewHolder>() {

    class PesanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pengirimTextView: TextView = itemView.findViewById(R.id.pengirimTextView)
        val isiTextView: TextView = itemView.findViewById(R.id.isiTextView)
        val waktuTextView: TextView = itemView.findViewById(R.id.waktuTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PesanViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pesan, parent, false)
        return PesanViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PesanViewHolder, position: Int) {
        val currentItem = listPesan[position]
        holder.pengirimTextView.text = currentItem.pengirim
        holder.isiTextView.text = currentItem.isi
        holder.waktuTextView.text = currentItem.waktu
    }

    override fun getItemCount() = listPesan.size
}