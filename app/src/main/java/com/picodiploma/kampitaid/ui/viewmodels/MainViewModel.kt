package com.picodiploma.kampitaid.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.picodiploma.kampitaid.data.QuakeRepository

class MainViewModel(private val quakeRepository: QuakeRepository): ViewModel() {

    fun getListQuake() = quakeRepository.getListQuake()

    fun getSearchQuake(title: String?) = quakeRepository.getSearchQuake(title)

}