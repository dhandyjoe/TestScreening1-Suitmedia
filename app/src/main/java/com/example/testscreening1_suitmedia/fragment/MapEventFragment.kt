package com.example.testscreening1_suitmedia.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testscreening1_suitmedia.R
import com.example.testscreening1_suitmedia.activity.MainActivity
import com.example.testscreening1_suitmedia.adapter.CardEventsAdapter
import com.example.testscreening1_suitmedia.adapter.MapEventAdapter
import com.example.testscreening1_suitmedia.databinding.FragmentMapEventBinding
import com.example.testscreening1_suitmedia.model.Events
import com.example.testscreening1_suitmedia.utils.DataEvents
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MapEventFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MapEventFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentMapEventBinding
    private var listEvents: ArrayList<Events>? = null
    private lateinit var mapsFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapEventBinding.inflate(inflater, container, false)
        listEvents = DataEvents.listEvents

        binding.rvMapEvents.setHasFixedSize(true)
        showRecycleViewMap()

        mapsFragment = MapsFragment()
        val transaction: FragmentTransaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_map, mapsFragment).commit()

        return binding.root
    }

    private fun showRecycleViewMap () {
        // Connect Adapter
        binding.rvMapEvents.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL ,false)
        val data = MapEventAdapter(listEvents!!)
        binding.rvMapEvents.adapter = data

        // Intent Data
        data.setOnClickListener(object : MapEventAdapter.OnClickListener{
            override fun onClick(position: Int, model: Events) {
                val bundle = Bundle()
                bundle.putString("markertitle", listEvents!![position].name)
                val mapsFragment = MapsFragment()
                mapsFragment.arguments = bundle

                Toast.makeText(context, listEvents!![position].name, Toast.LENGTH_SHORT).show()
            }
        })
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MapEventFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MapEventFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}