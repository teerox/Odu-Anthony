package com.example.anthonyodu

import androidx.lifecycle.MutableLiveData
import com.example.anthonyodu.model.CarOwnerList
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.model.FilterArray
import com.example.anthonyodu.repository.FilterRepository
import java.io.File

class FakeRepository(private var taskRemote:FakeDataSource,private var tasklocal:FakeDataSource):FilterRepository{
    override fun getFilter(): MutableLiveData<FilterArray>? {
      return taskRemote.getAll()

       }

    override suspend fun readFile(absoluteFile: File): CarOwnerList {
       return tasklocal.readFile(absoluteFile)
         }


}