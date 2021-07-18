package com.example.testscreening1_suitmedia.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testscreening1_suitmedia.adapter.CardEventsAdapter
import com.example.testscreening1_suitmedia.utils.DataEvents
import com.example.testscreening1_suitmedia.model.Events
import com.example.testscreening1_suitmedia.databinding.ActivityEventBinding
import com.example.testscreening1_suitmedia.utils.UserPreferences

class EventActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventBinding
    private var listEvents: ArrayList<Events>? = null
    private lateinit var userPreferences: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userPreferences = UserPreferences(this)
        binding.rvEvents.setHasFixedSize(true)
        listEvents = DataEvents.listEvents
        showRecycleView()

    }

    private fun showRecycleView () {
        // Connect Adapter
        binding.rvEvents.layoutManager = LinearLayoutManager(this)
        val data = CardEventsAdapter(listEvents!!)
        binding.rvEvents.adapter = data

        // Intent Data
        data.setOnClickListener(object : CardEventsAdapter.OnClickListener{
            override fun onClick(position: Int, model: Events) {
                val intent = Intent(this@EventActivity, MainActivity::class.java)
                userPreferences.setNameEvent(model.name.toString())
                userPreferences.setStatusEvent(true)
                startActivity(intent)
                finish()
            }
        })
    }
}