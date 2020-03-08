package com.example.anthonyodu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.model.FilterArray
import com.example.anthonyodu.repository.FilterRepository
import kotlinx.coroutines.runBlocking

class FilterViewModel(private val filterRepository: FilterRepository):ViewModel(){

    private var _filterList = MutableLiveData<FilterArray>()
    val filterList: LiveData<FilterArray>
        get() = _filterList

    init {
        initializeFetch()
    }

    private fun initializeFetch() {

        filterRepository.getFilter()?.let {
            _filterList = it

        }

    }
}