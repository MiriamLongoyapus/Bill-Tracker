package com.example.mylogin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.mylogin.databinding.ActivityRegisterBinding
import com.example.mylogin.models.RegisterRequest
import com.example.mylogin.viewmodel.UserViewModel

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
        binding.btnRegister.setOnClickListener {
            validateRegistration()
            clearErrors()
        }
        userViewModel.regLiveData.observe(this) { regResponse ->
            Toast.makeText(this, regResponse.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        userViewModel.errorLiveData.observe(this) { err ->
            Toast.makeText(this, err, Toast.LENGTH_LONG).show()
        }

    }
    fun validateRegistration() {
        val firstName=binding.etUserName.text.toString()
        val lastName=binding.etLastName.text.toString()
        val phoneNumber=binding.etPhoneNumber.text.toString()
        val email = binding.etEmailAdress.text.toString()
        val password = binding.etPassword.text.toString()
        val confirm=binding.etConfirmPassword.text.toString()
        var error = false

        if (firstName.isBlank()) {
            error = true
            binding.tilUserName.error = "First name is required"
        }
        if (lastName.isBlank()) {
            binding.tilLastName.error = "First name is required"
            error = true
        }
        if (email.isBlank()) {
            binding.tilEmailAdress.error = "Email is required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
            error = true
        }
        if (phoneNumber.isBlank()) {
            binding.tilPhoneNumber.error = "Your phone number is required"
            error = true
        }
        if(!error){
            val registerRequest= RegisterRequest(
                firstName=firstName,
                lastName = lastName,
                email=email,
                password = password,
                phoneNumber = phoneNumber,
            )
            userViewModel.registerUser(registerRequest)


        }
    }

    fun clearErrors() {
        binding.tilUserName.error = null
        binding.tilLastName
        binding.tilPhoneNumber.error = null
        binding.tilPassword.error = null
        binding.tilPhoneNumber.error = null
        binding.tilConfirmPassword.error=null
    }
}

//    fun validateRegistration() {
//        val name = binding.etUsername.text.toString()
//        val email=binding.etEmail .text.toString()
//        val password =binding.etPassword .text.toString()
//        val confirm=binding.etConfirmPassword.text.toString()
//        var error = false
//        if (name.isBlank()) {
//            binding.tilUsername.error = "Name required"
//            error=true
//        }
//        if (name.isBlank()) {
//            binding.tilEmail.error = "Email required"
//            error=true
//        }
//
//        if (name.isBlank()) {
//            binding.tilPassword.error = "Password required"
//            error=true
//        }
//        if (confirm!=password){
//            binding.tilConfirmPassword.error="Try again"
//            error=true
//        }
//        if (!error){
//            val intent=Intent(this,LoginActivity::class.java)
//            startActivity(intent)
//        }
//    }
//}


