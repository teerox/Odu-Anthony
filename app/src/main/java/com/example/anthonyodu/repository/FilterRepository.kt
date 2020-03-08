package com.example.anthonyodu.repository

import androidx.lifecycle.MutableLiveData
import com.example.anthonyodu.model.CarOwnerList
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.model.FilterArray
import java.io.File

interface FilterRepository {

    fun getFilter(): MutableLiveData<FilterArray>?

    suspend fun readFile(absoluteFile: File): CarOwnerList

    suspend fun filter(list: CarOwnerList,criteria: Filter):CarOwnerList

}