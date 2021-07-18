package com.example.testscreening1_suitmedia.utils

import com.example.testscreening1_suitmedia.R
import com.example.testscreening1_suitmedia.model.Events

object DataEvents {
    // resource data event offline

    private val image = intArrayOf(
        R.drawable.dota,
        R.drawable.euro_2020,
        R.drawable.kuliner,
        R.drawable.live_music,
        R.drawable.moto_gp
    )

    private val name = arrayOf(
        "DOTA Tournament 2020",
        "EURO 2020",
        "Festival Kuliner Serpong",
        "Cafe Live Music",
        "MotoGP World Championship"
    )

    private val tanggal = arrayOf(
        "30 June 2020",
        "01 Jan 2020",
        "26 May 2020",
        "01 August 2020",
        "25 Des 2020",
    )

    val listEvents: ArrayList<Events>
        get() {
            val list = arrayListOf<Events>()
            for (position in image.indices) {
                val event = Events()
                event.image = image[position]
                event.name = name[position]
                event.tanggal = tanggal[position]
                list.add(event)
            }
            return list
        }
}