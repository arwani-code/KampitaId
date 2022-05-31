package com.picodiploma.kampitaid.ui.fragments

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.picodiploma.kampitaid.R
import com.picodiploma.kampitaid.databinding.FragmentHomeKampitaBinding

class HomeKampitaFragment : Fragment() {

    private var _binding: FragmentHomeKampitaBinding? = null
    private val binding get() = _binding

    private val callback = OnMapReadyCallback { googleMap ->
        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeKampitaBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        binding?.frameButton?.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_listFragment)
        }

        binding?.ivSearch?.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_listSearchFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}