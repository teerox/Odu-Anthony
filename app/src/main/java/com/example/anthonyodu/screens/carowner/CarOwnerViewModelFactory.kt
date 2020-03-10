package com.example.anthonyodu.screens.carowner


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.repository.FilterRepository

class CarOwnerViewModelFactory(private var tasksrepository:FilterRepository, private var data:Filter):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>) = (CarOwnerViewModel(tasksrepository,data) as T)
}

