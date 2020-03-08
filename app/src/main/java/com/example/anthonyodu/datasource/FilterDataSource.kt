package com.example.anthonyodu.datasource

import androidx.lifecycle.MutableLiveData
import com.example.anthonyodu.model.FilterArray

interface FilterDataSource<T>{
     fun getAll(): MutableLiveData<T>?
}