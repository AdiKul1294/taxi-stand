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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.*
import java.lang.StringBuilder

class BookingsFragment : Fragment() {
    lateinit var binding: FragmentBookingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookings, container, false)

        val fAuth = FirebaseAuth.getInstance()
        val fStore = FirebaseFirestore.getInstance()
        val userId = fAuth.currentUser!!.uid
        var bookings = mutableListOf<Booking>()
        var dRef: DocumentReference


        for(i in 1..20) {
            dRef = fStore.collection("Bookings").document(userId.plus(i))
            dRef.addSnapshotListener { value, error ->
                val dest = value!!.getString("destination").toString()
                if(!(dest.equals("null"))) {
                    bookings.add(
                        Booking(
                            value!!.getString("destination").toString(),
                            value!!.getString("time").toString(),
                            value!!.getString("date").toString()
                        )
                    )
                    DataBase.bookingNo = i
                }
                val adapter = MyBookingsAdapter(bookings)
                binding.rvBf.apply {
                    this.adapter = adapter
                    layoutManager = LinearLayoutManager(getContext())
                }
            }
        }

        return binding.root
    }

}