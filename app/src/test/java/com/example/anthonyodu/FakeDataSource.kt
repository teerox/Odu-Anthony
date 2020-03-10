package com.example.anthonyodu

import androidx.lifecycle.MutableLiveData
import com.example.anthonyodu.datasource.FilterDataSource
import com.example.anthonyodu.model.CarOwner
import com.example.anthonyodu.model.CarOwnerList
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.model.FilterArray
import java.io.File

class FakeDataSource():FilterDataSource<FilterArray>{
    override fun getAll(): MutableLiveData<FilterArray>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun readFile(absoluteFile: File): CarOwnerList {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}