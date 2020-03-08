package com.example.anthonyodu.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.anthonyodu.repository.FilterRepository

class ViewModelFactory (private val taskRepository:FilterRepository):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>) = (FilterViewModel(taskRepository) as T)
}