package com.example.testscreening1_suitmedia.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testscreening1_suitmedia.R
import com.example.testscreening1_suitmedia.adapter.CardEventsAdapter
import com.example.testscreening1_suitmedia.utils.DataEvents
import com.example.testscreening1_suitmedia.model.Events
import com.example.testscreening1_suitmedia.databinding.ActivityEventBinding
import com.example.testscreening1_suitmedia.fragment.EventFragment
import com.example.testscreening1_suitmedia.fragment.MapEventFragment
import com.example.testscreening1_suitmedia.utils.UserPreferences

class EventActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarEvents)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = "MESSAGE FROM CODI"
            binding.toolbarEvents.setNavigationIcon(R.drawable.btn_back_normal)
            binding.toolbarEvents.setNavigationOnClickListener {
                onBackPressed()
            }
        }

        loadFragment(EventFragment())
    }

    private fun loadFragment (fragment: Fragment): Boolean {
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            return true
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.media -> loadFragment(MapEventFragment())
        }

        return super.onOptionsItemSelected(item)
    }
}