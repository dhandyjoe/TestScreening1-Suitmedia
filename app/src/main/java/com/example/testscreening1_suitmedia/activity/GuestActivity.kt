package com.example.testscreening1_suitmedia.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
                val intent = Intent(this@GuestActivity, MainActivity::class.java)
                intent.putExtra(MainActivity.BIRTHDATE, model.birthdate)
                userPreferences.setNameGuest(model.name)
                userPreferences.setStatusGuest(true)
                startActivity(intent)
                finish()
            }
        })
    }
}