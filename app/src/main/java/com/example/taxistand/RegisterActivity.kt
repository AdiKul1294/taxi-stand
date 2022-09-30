package com.example.taxistand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.taxistand.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.accLoginTv.setOnClickListener{
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            finish()
        }

        binding.registerBtnCv.setOnClickListener {
            if(binding.emailRegTxtInput.text!!.isEmpty()){
                Toast.makeText(
                    this@RegisterActivity,
                    "Please enter email!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else if (binding.passwordRegTxtInput.text!!.isEmpty()){
                Toast.makeText(
                    this@RegisterActivity,
                    "Please enter password!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else    {
                val firstName: String = binding.firstnameRegTxtInput.text.toString()
                val lastName: String = binding.lastnameRegTxtInput.text.toString()
                val email: String = binding.emailRegTxtInput.text.toString()
                val password: String = binding.passwordRegTxtInput.text.toString()

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val firebaseUser: FirebaseUser = task.result!!.user!!
                        val fstore = FirebaseFirestore.getInstance()

                        Toast.makeText(
                            this@RegisterActivity,
                            "User Registered Successfully",
                            Toast.LENGTH_SHORT
                        ).show()

                        val userId: String = firebaseUser.uid
                        val df: DocumentReference = fstore.collection("users").document(userId)
                        val user = hashMapOf<String, String>()
                        user.put("first_name", firstName)
                        user.put("last_name", lastName)
                        user.put("email", email)
                        user.put("password", password)
                        df.set(user)

                        val book = hashMapOf<String, String>()
                        val df1 = fstore.collection("Booking Num").document(userId)
                        book.put("no_of_bookings", "0")
                        df1.set(book)

                        val intent =
                            Intent(this@RegisterActivity, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        intent.putExtra("user_id", firebaseUser.uid)
                        intent.putExtra("email_id", email)
                        startActivity(intent)
                        finish()
                    }
                    else {
                        Toast.makeText(
                            this@RegisterActivity,
                            task.exception!!.message.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            }
        }
    }
}