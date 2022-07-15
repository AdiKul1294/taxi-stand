package com.example.taxistand

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.taxistand.databinding.FragmentSelectCarBinding

class SelectCarFragment : Fragment() {
    lateinit var binding: FragmentSelectCarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_select_car, container, false)
    return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardView9.setOnClickListener {
            findNavController().navigate(R.id.action_selectCarFragment_to_selectRideFragment)
        }

        binding.cardView1.setOnClickListener {
            binding.cardView1.alpha = 1.0F
            binding.cardView5.alpha = 1.0F
            binding.cardView2.alpha = 0.75F
            binding.cardView3.alpha = 0.75F
            binding.cardView4.alpha = 0.75F
            binding.cardView6.alpha = 0.5F
            binding.cardView7.alpha = 0.5F
            binding.cardView8.alpha = 0.5F
        }

        binding.cardView2.setOnClickListener {
            binding.cardView2.alpha = 1.0F
            binding.cardView6.alpha = 1.0F
            binding.cardView1.alpha = 0.75F
            binding.cardView3.alpha = 0.75F
            binding.cardView4.alpha = 0.75F
            binding.cardView5.alpha = 0.5F
            binding.cardView7.alpha = 0.5F
            binding.cardView8.alpha = 0.5F
        }

        binding.cardView3.setOnClickListener {
            binding.cardView3.alpha = 1.0F
            binding.cardView7.alpha = 1.0F
            binding.cardView2.alpha = 0.75F
            binding.cardView1.alpha = 0.75F
            binding.cardView4.alpha = 0.75F
            binding.cardView6.alpha = 0.5F
            binding.cardView5.alpha = 0.5F
            binding.cardView8.alpha = 0.5F
        }

        binding.cardView4.setOnClickListener {
            binding.cardView4.alpha = 1.0F
            binding.cardView8.alpha = 1.0F
            binding.cardView2.alpha = 0.75F
            binding.cardView3.alpha = 0.75F
            binding.cardView1.alpha = 0.75F
            binding.cardView6.alpha = 0.5F
            binding.cardView7.alpha = 0.5F
            binding.cardView5.alpha = 0.5F
        }

        binding.cardView5.setOnClickListener {
            binding.cardView1.alpha = 1.0F
            binding.cardView5.alpha = 1.0F
            binding.cardView2.alpha = 0.75F
            binding.cardView3.alpha = 0.75F
            binding.cardView4.alpha = 0.75F
            binding.cardView6.alpha = 0.5F
            binding.cardView7.alpha = 0.5F
            binding.cardView8.alpha = 0.5F
        }

        binding.cardView6.setOnClickListener {
            binding.cardView2.alpha = 1.0F
            binding.cardView6.alpha = 1.0F
            binding.cardView1.alpha = 0.75F
            binding.cardView3.alpha = 0.75F
            binding.cardView4.alpha = 0.75F
            binding.cardView5.alpha = 0.5F
            binding.cardView7.alpha = 0.5F
            binding.cardView8.alpha = 0.5F
        }

        binding.cardView7.setOnClickListener {
            binding.cardView3.alpha = 1.0F
            binding.cardView7.alpha = 1.0F
            binding.cardView2.alpha = 0.75F
            binding.cardView1.alpha = 0.75F
            binding.cardView4.alpha = 0.75F
            binding.cardView6.alpha = 0.5F
            binding.cardView5.alpha = 0.5F
            binding.cardView8.alpha = 0.5F
        }

        binding.cardView8.setOnClickListener {
            binding.cardView4.alpha = 1.0F
            binding.cardView8.alpha = 1.0F
            binding.cardView2.alpha = 0.75F
            binding.cardView3.alpha = 0.75F
            binding.cardView1.alpha = 0.75F
            binding.cardView6.alpha = 0.5F
            binding.cardView7.alpha = 0.5F
            binding.cardView5.alpha = 0.5F
        }



    }

}