package com.example.testscreening1_suitmedia.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.testscreening1_suitmedia.R
import com.example.testscreening1_suitmedia.databinding.ActivityHomeBinding
import com.example.testscreening1_suitmedia.utils.UserPreferences

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var userPreferences: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userPreferences = UserPreferences(this)
        userPreferences.deleteAllData()

        binding.btnNext.setOnClickListener {
            if(binding.etName.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                userPreferences.setNameCustomer(binding.etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}