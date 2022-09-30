package com.example.taxistand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.taxistand.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.hide()

        binding.accRegTv.setOnClickListener{
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            finish()
        }

        binding.loginBtnCv.setOnClickListener {
            if(binding.emailTxtInput.text!!.isEmpty()){
                Toast.makeText(
                    this@LoginActivity,
                    "Please enter email!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else if (binding.passwordTxtInput.text!!.isEmpty()){
                Toast.makeText(
                    this@LoginActivity,
                    "Please enter password!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else    {
                val email: String = binding.emailTxtInput.text.toString()
                val password: String = binding.passwordTxtInput.text.toString()

                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val firebaseUser: FirebaseUser = task.result!!.user!!

                        Toast.makeText(
                            this@LoginActivity,
                            "Logged in Successfully",
                            Toast.LENGTH_SHORT
                        ).show()

                        val intent =
                            Intent(this@LoginActivity, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        intent.putExtra("user_id", FirebaseAuth.getInstance().currentUser!!.uid)
                        intent.putExtra("email_id", email)
                        startActivity(intent)
                        finish()
                    }
                    else {
                        Toast.makeText(
                            this@LoginActivity,
                            task.exception!!.message.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            }
        }
    }
}