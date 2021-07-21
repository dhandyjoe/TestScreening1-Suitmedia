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

    private val description = arrayOf(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sed massa consectetur, blandit arcu vitae, finibus massa.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sed massa consectetur, blandit arcu vitae, finibus massa.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sed massa consectetur, blandit arcu vitae, finibus massa.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sed massa consectetur, blandit arcu vitae, finibus massa.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sed massa consectetur, blandit arcu vitae, finibus massa."
    )

    private val latitude = arrayOf(
        -6.2,
        54.5,
        -6.9,
        -6.9,
        48.1
    )

    private val longitude = arrayOf(
        106.8,
        15.2,
        107.6,
        110.4,
        100.1
    )

    val listEvents: ArrayList<Events>
        get() {
            val list = arrayListOf<Events>()
            for (position in image.indices) {
                val event = Events()
                event.image = image[position]
                event.name = name[position]
                event.tanggal = tanggal[position]
                event.description = description[position].toString()
                event.latitude = latitude[position]
                event.longitude = longitude[position]
                list.add(event)
            }
            return list
        }
}