package com.picodiploma.kampitaid.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.picodiploma.kampitaid.R
import com.picodiploma.kampitaid.data.Result
import com.picodiploma.kampitaid.data.local.entity.QuakeEntity
import com.picodiploma.kampitaid.databinding.FragmentListKampitaBinding
import com.picodiploma.kampitaid.databinding.FragmentListSearchBinding
import com.picodiploma.kampitaid.ui.adapters.QuakeAdapter
import com.picodiploma.kampitaid.ui.viewmodels.MainViewModel
import com.picodiploma.kampitaid.utils.ViewModelFactory

class ListSearchFragment : Fragment() {

    private lateinit var factory: ViewModelFactory
    private lateinit var quakeAdapter: QuakeAdapter
    private val viewModel: MainViewModel by viewModels { factory }
    private var _binding: FragmentListSearchBinding? = null
    private val binding get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = ViewModelFactory.getInstance(requireActivity())
        quakeAdapter = QuakeAdapter()

        setupRv()
        setupAction()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListSearchBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupRv() {
        binding?.rvQuake?.apply {
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
        val action = ListSearchFragmentDirections.actionListSearchFragmentToDetailKampitaFragment(quake)
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

    private fun setupAction() {
        binding?.searchQuake?.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(query: String?): Boolean {
                if(query != null){
                    searchQuake(query)
                }
                return true
            }
        })
    }

    private fun searchQuake(query: String) {
        val searchQuery = "%$query%"
        viewModel.getSearchQuake(searchQuery).observe(viewLifecycleOwner){ result ->
            if (result != null){
                when(result){
                    is Result.Success -> {
                        val quakeItem = result.data
                        quakeAdapter.submitList(quakeItem)
                    }
                    else -> {}
                }
            }
        }
    }
}