package com.example.anthonyodu.screens.carowner


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.anthonyodu.model.Filter

class CarOwnerViewModelFactory(private val dataSource: Filter) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CarOwnerViewModel::class.java)) {
            return CarOwnerViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

