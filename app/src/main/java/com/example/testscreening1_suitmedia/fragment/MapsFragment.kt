package com.example.testscreening1_suitmedia.fragment

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
    private val marker = arguments?.getString("markertitle")

    private val callback = OnMapReadyCallback { googleMap ->

        val dota = LatLng(listEvents!![0].latitude, listEvents!![0].longitude)
        googleMap.addMarker(MarkerOptions().position(dota).title("Dota Tournament 2020"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(dota))

        val euro2020 = LatLng(listEvents!![1].latitude, listEvents!![1].longitude)
        googleMap.addMarker(MarkerOptions().position(euro2020).title("Euro 2020"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(euro2020))

        val festivalKuliner = LatLng(listEvents!![2].latitude, listEvents!![2].longitude)
        googleMap.addMarker(MarkerOptions().position(festivalKuliner).title("Festival Kuliner Serpong"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(festivalKuliner))

        val liveMusic = LatLng(	listEvents!![3].latitude,listEvents!![3].longitude)
        googleMap.addMarker(MarkerOptions().position(liveMusic).title("Cafe Live Music"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(liveMusic))

        val MotoGP = LatLng(listEvents!![4].latitude, listEvents!![4].longitude)
        googleMap.addMarker(MarkerOptions().position(MotoGP).title("MotoGP World Championship"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(MotoGP))

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