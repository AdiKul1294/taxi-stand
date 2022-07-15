package com.example.taxistand

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.taxistand.databinding.FragmentBookingsBinding

class BookingsFragment : Fragment() {
    lateinit var binding: FragmentBookingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookings, container, false)
        return binding.root
    }

}