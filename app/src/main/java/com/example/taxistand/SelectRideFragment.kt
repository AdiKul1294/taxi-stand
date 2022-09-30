package com.example.taxistand

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
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

        val inflater = TransitionInflater.from(requireContext())
        exitTransition = inflater.inflateTransition(R.transition.fade)
        enterTransition = inflater.inflateTransition(R.transition.slide_right)

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

        binding.selectRideCvSrf.setOnClickListener{
            DataBase.isCabBooked = true
            findNavController().navigate(R.id.action_selectRideFragment_to_bookingsFragment)
        }

        return binding.root
    }

}