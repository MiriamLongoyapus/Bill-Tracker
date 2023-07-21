package com.example.mylogin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.mylogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //    the binding property is used to access the views in the activity xml
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        },3000)

    }
}



