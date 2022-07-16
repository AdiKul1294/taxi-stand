package com.example.taxistand

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taxistand.DataClasses.Car
import com.example.taxistand.adapters.SelectRideAdapter
import com.example.taxistand.databinding.FragmentSelectRideBinding

class SelectRideFragment : Fragment() {
    lateinit var binding: FragmentSelectRideBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_select_ride, container, false)

        var CarsList = mutableListOf<Car>(
            Car("Swift Dzire", "UP 75 Y 1254", "Rs 500 / day", R.drawable.urus),
            Car("Swift Dzire", "UP 75 Y 1254", "Rs 500 / day", R.drawable.urus),
            Car("Swift Dzire", "UP 75 Y 1254", "Rs 500 / day", R.drawable.urus),
            Car("Swift Dzire", "UP 75 Y 1254", "Rs 500 / day", R.drawable.urus),
            Car("Swift Dzire", "UP 75 Y 1254", "Rs 500 / day", R.drawable.urus),
            Car("Swift Dzire", "UP 75 Y 1254", "Rs 500 / day", R.drawable.urus),
            Car("Swift Dzire", "UP 75 Y 1254", "Rs 500 / day", R.drawable.urus),
            Car("Swift Dzire", "UP 75 Y 1254", "Rs 500 / day", R.drawable.urus)
        )

        val adapter = SelectRideAdapter(CarsList)
        binding.rvSrf.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }

}