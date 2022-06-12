package com.picodiploma.kampitaid.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.picodiploma.kampitaid.R
import com.picodiploma.kampitaid.data.Result
import com.picodiploma.kampitaid.data.local.entity.QuakeEntity
import com.picodiploma.kampitaid.databinding.FragmentListKampitaBinding
import com.picodiploma.kampitaid.ui.adapters.QuakeAdapter
import com.picodiploma.kampitaid.ui.viewmodels.MainViewModel
import com.picodiploma.kampitaid.utils.ViewModelFactory

class ListKampitaFragment : Fragment() {

    private lateinit var factory: ViewModelFactory
    private lateinit var quakeAdapter: QuakeAdapter
    private var _binding: FragmentListKampitaBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListKampitaBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = ViewModelFactory.getInstance(requireActivity())
        quakeAdapter = QuakeAdapter()

        setupViewModel()
        setupRv()

    }

    private fun setupViewModel(){
         val viewModel: MainViewModel by viewModels { factory }
         viewModel.getListQuake().observe(viewLifecycleOwner){ result ->
             if(result != null){
                 when(result) {
                     is Result.Loading -> binding?.progressBar?.visibility = View.VISIBLE
                     is Result.Success -> {
                         val quakeData = result.data
                         binding?.progressBar?.visibility = View.GONE
                         quakeAdapter.submitList(quakeData)
                     }
                     is Result.Error -> {
                         binding?.progressBar?.visibility = View.GONE
                     }
                 }
             }
         }
    }

    private fun setupRv() {
        binding?.rvNews?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = quakeAdapter
            setHasFixedSize(true)
        }

        quakeAdapter.onItemClickCallback(object : QuakeAdapter.OnItemClickCallback{
            override fun onItemClicked(quake: QuakeEntity) {
                setSelectedQuake(quake)
            }
        })
    }

    private fun setSelectedQuake(quake: QuakeEntity) {
        val action = ListKampitaFragmentDirections.actionListFragmentToDetailKampitaFragment(quake)
        action.quake.elevation = quake.elevation
        action.quake.station = quake.station
        action.quake.magnitude = quake.magnitude
        action.quake.station_location = quake.station_location
        action.quake.latitude = quake.latitude
        action.quake.longitude = quake.longitude
        action.quake.publishedAt = quake.publishedAt
        action.quake.radius = quake.radius

        view?.findNavController()?.navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}