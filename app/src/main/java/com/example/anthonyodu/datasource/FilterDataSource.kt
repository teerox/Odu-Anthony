package com.example.anthonyodu.datasource

import androidx.lifecycle.MutableLiveData
import com.example.anthonyodu.model.CarOwnerList
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.model.FilterArray
import java.io.File

interface FilterDataSource<T>{
     fun getAll(): MutableLiveData<T>?

     suspend fun readFile(absoluteFile: File): CarOwnerList

     suspend fun filter(list: CarOwnerList,criteria: Filter):CarOwnerList
}