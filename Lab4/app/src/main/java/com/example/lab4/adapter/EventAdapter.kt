package com.example.lab4.adapter

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab4.R
import com.example.lab4.model.Event

class EventAdapter(private val events:List<Event>): RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
        val name: TextView = itemView.findViewById(R.id.etName)
        val data:TextView=itemView.findViewById(R.id.etDate)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder
    {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.event_item, parent, false)
        return EventViewHolder(itemView)
    }
    override fun getItemCount(): Int {
        return events.size
    }
    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.image.setImageBitmap(events[position].path as Bitmap)
        holder.name.text = events[position].name
        holder.data.text = events[position].data.toString()
    }
}