package com.picodiploma.kampitaid.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.picodiploma.kampitaid.data.QuakeRepository
import com.picodiploma.kampitaid.di.Injection
import com.picodiploma.kampitaid.ui.viewmodels.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory private constructor(
    private val quakeRepository: QuakeRepository
) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(quakeRepository) as T
        }
        throw IllegalArgumentException("Unknow Viewmodel class ${modelClass.name}")
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this){
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }.also { instance = it }
    }
}