package com.picodiploma.kampitaid.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.picodiploma.kampitaid.R
import com.picodiploma.kampitaid.databinding.FragmentListKampitaBinding

class ListKampitaFragment : Fragment() {

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

        binding?.ivBack?.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_listFragment_to_homeFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}