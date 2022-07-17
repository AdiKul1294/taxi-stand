package com.example.taxistand

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taxistand.DataClasses.Booking
import com.example.taxistand.adapters.MyBookingsAdapter
import com.example.taxistand.databinding.FragmentBookingsBinding

class BookingsFragment : Fragment() {
    lateinit var binding: FragmentBookingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookings, container, false)

        var bookings = mutableListOf<Booking>(
            Booking("Mumbai to Goa", "6AM", "29/03/2022"),
            Booking("Mumbai to Goa", "6AM", "29/03/2022"),
            Booking("Mumbai to Goa", "6AM", "29/03/2022"),
            Booking("Mumbai to Goa", "6AM", "29/03/2022"),
            Booking("Mumbai to Goa", "6AM", "29/03/2022"),
            Booking("Mumbai to Goa", "6AM", "29/03/2022"),
            Booking("Mumbai to Goa", "6AM", "29/08/2022"),
            Booking("Mumbai to Goa", "6AM", "29/08/2022"),
        )

        val adapter = MyBookingsAdapter(bookings)
        binding.rvBf.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }

}