package com.example.testscreening1_suitmedia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.testscreening1_suitmedia.databinding.ItemRecycleViewEventsBinding
import com.example.testscreening1_suitmedia.model.Events

class CardEventsAdapter (val listEvents: ArrayList<Events>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private class MyViewHolder(val binding: ItemRecycleViewEventsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(ItemRecycleViewEventsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = listEvents[position]

        if (holder is MyViewHolder) {
            Glide.with(holder.itemView.context)
                .load(model.image)
                .apply(RequestOptions().override(80, 80))
                .into(holder.binding.imgPoster)

            holder.binding.tvNamaEvent.text = model.name
            holder.binding.tvTanggalEvent.text = model.tanggal

            holder.itemView.setOnClickListener {
                onClickListener!!.onClick(position, model)
            }
        }
    }

    override fun getItemCount(): Int {
        return listEvents.size
    }

    // code for click listener
    private var onClickListener: OnClickListener? = null

    fun setOnClickListener (onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick (position: Int, model: Events)
    }
}