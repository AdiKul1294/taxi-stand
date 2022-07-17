package com.example.taxistand.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.taxistand.DataClasses.Booking
import com.example.taxistand.R

class MyBookingsAdapter(val bookings: List<Booking>): RecyclerView.Adapter<MyBookingsAdapter.MyBookingsViewHolder>(){

    inner class MyBookingsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBookingsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bookings_item, parent, false)
        return MyBookingsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyBookingsViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.destination_tv_mbf).text = bookings[position].destination
            findViewById<TextView>(R.id.time_tv_mbf).text = bookings[position].time
            findViewById<TextView>(R.id.date_tv_mbf).text = bookings[position].date
        }
    }

    override fun getItemCount(): Int {
        return bookings.size
    }


}