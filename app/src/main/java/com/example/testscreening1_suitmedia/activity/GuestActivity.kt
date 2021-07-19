package com.example.testscreening1_suitmedia.activity

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.testscreening1_suitmedia.R
import com.example.testscreening1_suitmedia.adapter.GuestAdapter
import com.example.testscreening1_suitmedia.api.RetrofitClient
import com.example.testscreening1_suitmedia.databinding.ActivityGuestBinding
import com.example.testscreening1_suitmedia.model.GuestResponse
import com.example.testscreening1_suitmedia.utils.UserPreferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GuestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGuestBinding
    private lateinit var userPreferences: UserPreferences
    private var dataGuest: ArrayList<GuestResponse>? = null
    private var guestAdapter: GuestAdapter? = null
    private lateinit var swipeContainer: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        swipeContainer = binding.swipeContainer
        //** Set the colors of the Pull To Refresh View
        swipeContainer.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(this, R.color.white))

        swipeContainer.setOnRefreshListener {
            dataGuest!!.clear()
            showGuest()
            swipeContainer.isRefreshing = false
        }

        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.black,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light);

        userPreferences = UserPreferences(this)
        showGuest()
    }

    private fun showGuest() {
        RetrofitClient.instance.getProfile()
            .enqueue(object : Callback<ArrayList<GuestResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<GuestResponse>>,
                    response: Response<ArrayList<GuestResponse>>
                ) {
                    dataGuest = response.body()
                    guestAdapter = GuestAdapter(dataGuest!!)
                    showRecycleView()
                }

                override fun onFailure(call: Call<ArrayList<GuestResponse>>, t: Throwable) {
                    Toast.makeText(this@GuestActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }

    private fun showRecycleView () {
        // Connect Adapter
        binding.rvGuest.layoutManager = GridLayoutManager(this, 2)
        val data = GuestAdapter(dataGuest!!)
        binding.rvGuest.adapter = data

        // Intent Data
        data.setOnClickListener(object : GuestAdapter.OnClickListener{
            override fun onClick(position: Int, model: GuestResponse) {
                dialogPalindrome(model, monthPrime(model.birthdate))
            }
        })
    }

    private fun dialogPalindrome (model: GuestResponse, boolean: Boolean) {
        AlertDialog.Builder(this)
            .setMessage(if (!boolean) "isPrime" else "not prime")
            .setPositiveButton("Next", DialogInterface.OnClickListener { dialogInterface, i ->
                val intent = Intent(this@GuestActivity, MainActivity::class.java)
                intent.putExtra(MainActivity.BIRTHDATE, model.birthdate)
                userPreferences.setNameGuest(model.name)
                userPreferences.setStatusGuest(true)
                startActivity(intent)
                finish()
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
            })
            .show()
    }

    private fun monthPrime (string: String): Boolean {
        val number = string.split("-")
        var flag = false
        if (number[1].toInt() == 1) flag = true
        for (i in 2..number[1].toInt() / 2) {
            // condition for nonprime number
            if (number[1].toInt() % i == 0) {
                flag = true
                break
            }
        }
        return flag
    }
}