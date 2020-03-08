package com.example.anthonyodu.repository

import androidx.lifecycle.MutableLiveData
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.model.FilterArray

interface FilterRepository {

    fun getFilter(): MutableLiveData<FilterArray>?
}