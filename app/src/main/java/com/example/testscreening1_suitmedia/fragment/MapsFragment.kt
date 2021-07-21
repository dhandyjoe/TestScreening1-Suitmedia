package com.example.testscreening1_suitmedia.fragment

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testscreening1_suitmedia.R
import com.example.testscreening1_suitmedia.model.Events
import com.example.testscreening1_suitmedia.utils.DataEvents

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {
    private var listEvents: ArrayList<Events>? = null

    private val callback = OnMapReadyCallback { googleMap ->

        val dota = LatLng(-6.2, 106.8)
        googleMap.addMarker(MarkerOptions().position(dota).title("Dota Tournament 2020"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(dota))

        val euro2020 = LatLng(54.5, 15.2)
        googleMap.addMarker(MarkerOptions().position(euro2020).title("Euro 2020"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(euro2020))

        val festivalKuliner = LatLng(-6.9, 107.6)
        googleMap.addMarker(MarkerOptions().position(festivalKuliner).title("Festival Kuliner Serpong"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(festivalKuliner))

        val liveMusic = LatLng(	-6.9,110.4)
        googleMap.addMarker(MarkerOptions().position(liveMusic).title("Cafe Live Music"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(liveMusic))

        val MotoGP = LatLng(48.1, 100.1)
        googleMap.addMarker(MarkerOptions().position(liveMusic).title("MotoGP World Championship"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(liveMusic))

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listEvents = DataEvents.listEvents
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}