package com.example.taxistand.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.taxistand.DataClasses.Car
import com.example.taxistand.R

class SelectRideAdapter(val cars: List<Car>): RecyclerView.Adapter<SelectRideAdapter.SelectRideViewHolder>() {

    inner class SelectRideViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectRideViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.select_ride_item, parent, false)
        return SelectRideViewHolder(view)
    }

    override fun onBindViewHolder(holder: SelectRideViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<ImageView>(R.id.car_iv_sci).setImageResource(cars[position].carImageRes)
            findViewById<TextView>(R.id.car_name_tv_sci).text = cars[position].carName
            findViewById<TextView>(R.id.car_num_tv_sci).text = cars[position].carNum
            findViewById<TextView>(R.id.rate_tv_sci).text = cars[position].carRate
        }
    }

    override fun getItemCount(): Int {
        return cars.size
    }

}