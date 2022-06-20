package com.picodiploma.kampitaid.ui.fragments

import android.Manifest
import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.picodiploma.kampitaid.R
import com.picodiploma.kampitaid.databinding.FragmentHomeKampitaBinding
import com.picodiploma.kampitaid.ui.viewmodels.MainViewModel
import com.picodiploma.kampitaid.utils.ViewModelFactory
import com.picodiploma.kampitaid.data.Result

class HomeKampitaFragment : Fragment() {

    private lateinit var factory: ViewModelFactory
    private var _binding: FragmentHomeKampitaBinding? = null
    private val binding get() = _binding
    private lateinit var mMap: GoogleMap
    private val viewModel: MainViewModel by viewModels { factory }

    private val callback = OnMapReadyCallback { googleMap ->

        mMap = googleMap

        mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isCompassEnabled = true

        viewModel.getListQuake().observe(viewLifecycleOwner){ result ->
            if(result != null){
                when(result){
                    is Result.Loading -> binding?.progressBar?.visibility = View.VISIBLE
                    is Result.Success -> {
                        binding?.progressBar?.visibility = View.GONE
                        val data = result.data
                        for(item in data){
                                val location = item.longitude?.let { item.latitude?.let { it1 ->
                                    LatLng(
                                        it1, it)
                                } }
                            location?.let { MarkerOptions().position(it).title(
                                "Location"
                            ) }
                                ?.let { mMap.addMarker(it) }
                            location?.let { CameraUpdateFactory.newLatLng(it) }
                                ?.let { mMap.moveCamera(it) }
                        }
                    }
                    is Result.Error -> {
                        binding?.progressBar?.visibility = View.GONE
                        Toast.makeText(
                            context,
                            "Terjadi kesalahan" + result.error,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
        getMyLocation()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeKampitaBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = ViewModelFactory.getInstance(requireActivity())

        val mapFragment = childFragmentManager.findFragmentById(R.id.homeMap) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)


        binding?.barBottom?.setOnClickListener {
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

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                getMyLocation()
            }
        }
    private fun getMyLocation() {
        if (ContextCompat.checkSelfPermission(
                requireContext().applicationContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            mMap.isMyLocationEnabled = true
        } else {
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }
}