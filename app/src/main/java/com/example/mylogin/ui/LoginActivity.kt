package com.example.mylogin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mylogin.R
import com.example.mylogin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        validateLogin()
    }

    fun validateLogin() {
        val username = binding.etUserName.text.toString()
        val phoneNumber = binding.etPassword.text.toString()
        var error = false
        if (username.isBlank()) {
            binding.tilUserName.error= "Insert userName"
            error = true
        }
        if (phoneNumber.isBlank()) {
            binding.tilPassword.error = "Enter Password"
            error = true
        }
    }
}
