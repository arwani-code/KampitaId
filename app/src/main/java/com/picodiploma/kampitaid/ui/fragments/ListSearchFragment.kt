package com.picodiploma.kampitaid.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.picodiploma.kampitaid.R
import com.picodiploma.kampitaid.databinding.FragmentListKampitaBinding
import com.picodiploma.kampitaid.databinding.FragmentListSearchBinding

class ListSearchFragment : Fragment() {

    private var _binding: FragmentListSearchBinding? = null
    private val binding get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.ivBack?.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_listSearchFragment_to_homeFragment)
        }
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
}