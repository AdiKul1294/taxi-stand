package com.example.taxistand

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.taxistand.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {
    lateinit var binding: FragmentHomePageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_page, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bookCabBtnHome.setOnClickListener {
            findNavController().navigate(R.id.action_homePageFragment_to_selectLocationFragment)
        }
        binding.myBookingsBtnHome.setOnClickListener {
            findNavController().navigate(R.id.action_homePageFragment_to_bookingsFragment)
        }
    }
}