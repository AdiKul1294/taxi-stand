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
import com.example.taxistand.DataClasses.Booking
import com.example.taxistand.databinding.FragmentDateAndTimeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.*
import com.google.firebase.ktx.Firebase
import java.lang.StringBuilder

class DateAndTimeFragment : Fragment() {
    lateinit var binding: FragmentDateAndTimeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_date_and_time, container, false)

        val inflater = TransitionInflater.from(requireContext())
        exitTransition = inflater.inflateTransition(R.transition.fade)
        enterTransition = inflater.inflateTransition(R.transition.slide_right)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextCvDtf.setOnClickListener {
            val fAuth = FirebaseAuth.getInstance()
            val fStore = FirebaseFirestore.getInstance()
            val userId = fAuth.currentUser!!.uid.toString()
            val cRef: CollectionReference = fStore.collection("Bookings")

            var bookingNo = DataBase.bookingNo

            /*
            val dRef1 = fStore.collection("Booking Num").document(userId)
            dRef1.addSnapshotListener { value, error ->
                bookingNo = Integer.parseInt(value!!.getString("no_of_bookings").toString())
            }


            //DataBase.bookingNo++
            */

            val dRef1 = fStore.collection("Booking Num").document(userId)
            val user = hashMapOf<String, String>()
            user.put("no_of_bookings", bookingNo.toString())
            dRef1.set(user)

            val dRef = cRef.document(userId.plus(bookingNo+1))
            val bookings = hashMapOf<String, String>()
            bookings.put("destination", DataBase.destination)
            bookings.put("time", binding.timeEditDtf.text.toString())
            bookings.put("date", binding.dateEditDtf.text.toString())
            dRef.set(bookings)


            findNavController().navigate(R.id.action_dateAndTimeFragment_to_selectCarFragment)
        }

    }

}