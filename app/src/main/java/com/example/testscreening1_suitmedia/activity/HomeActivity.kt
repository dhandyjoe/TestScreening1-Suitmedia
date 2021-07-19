package com.example.testscreening1_suitmedia.activity

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
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
                dialogPalindrome(isPalindrome(binding.etName.text.toString()))
            }
        }
    }

    private fun dialogPalindrome (boolean: Boolean) {
        AlertDialog.Builder(this)
            .setMessage(if (boolean) "isPalindrome" else "not palindrome")
            .setPositiveButton("Next", DialogInterface.OnClickListener { dialogInterface, i ->
                val intent = Intent(this, MainActivity::class.java)
                userPreferences.setNameCustomer(binding.etName.text.toString())
                startActivity(intent)
                finish()
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
            })
            .show()
    }

    private fun isPalindrome(name: String): Boolean {
        val names = name.replace(" ", "")
        for (value in 0 until (names.length)) {
            val indeksAwal = value
            val indeksAkhir = names.length - value - 1

            if (names[indeksAwal] != names[indeksAkhir]) {
                return false
            }
        }
        return true
    }
}