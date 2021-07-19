package com.example.testscreening1_suitmedia.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.testscreening1_suitmedia.databinding.ActivityMainBinding
import com.example.testscreening1_suitmedia.utils.UserPreferences

class MainActivity : AppCompatActivity() {
    companion object {
        const val BIRTHDATE = "BIRTHDATE"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var userPreferences: UserPreferences // untuk menyimpan data sementara

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userPreferences = UserPreferences(this)
        val status = intent.extras
        val birthdate = status?.getString(BIRTHDATE)

        if (userPreferences.getNameCustomer() != null) {
            binding.tvStatusName.text = userPreferences.getNameCustomer()
        }
        if (userPreferences.getStatusEvent()) {
            binding.btnEvents.text = userPreferences.getNameEvent()
        }
        if (userPreferences.getStatusGuest()) {
            binding.btnGuest.text = userPreferences.getNameGuest()
        }
        if (birthdate != null) {
            Toast.makeText(this, dateView(birthdate), Toast.LENGTH_LONG).show()
        }

        binding.btnEvents.setOnClickListener {
            val intent = Intent(this, EventActivity::class.java)
            startActivity(intent)
        }

        binding.btnGuest.setOnClickListener {
            val intent = Intent(this, GuestActivity::class.java)
            startActivity(intent)
        }
    }

    // function untuk mengkalkulasi tanggal lahir
    private fun dateView(date: String): String {
        val number = date.split("-")
        if (number[2].toInt() % 2 == 0 && number[2].toInt() % 3 == 0) {
            return "iOS"
        } else if (number[2].toInt() % 2 == 0) {
            return "BLACKBERRY"
        } else if (number[2].toInt() % 3 == 0) {
            return "ANDROID"
        } else {
            return "Feature Phone"
        }
    }

}
