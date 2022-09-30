package com.example.taxistand

import android.os.Bundle
import android.provider.ContactsContract
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.taxistand.databinding.FragmentSelectLocationBinding
import java.lang.StringBuilder

class SelectLocationFragment : Fragment() {
    lateinit var binding: FragmentSelectLocationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_select_location, container, false)

        val inflater = TransitionInflater.from(requireContext())
        exitTransition = inflater.inflateTransition(R.transition.fade)
        enterTransition = inflater.inflateTransition(R.transition.slide_right)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextCvSlf.setOnClickListener {
            val sb = StringBuilder()
            sb.append(binding.pickEditSlf.text.toString())
            sb.append(" to ")
            sb.append(binding.dropEditSlf.text.toString())

            DataBase.destination = sb.toString()
            findNavController().navigate(R.id.action_selectLocationFragment_to_dateAndTimeFragment)
        }



    }

}