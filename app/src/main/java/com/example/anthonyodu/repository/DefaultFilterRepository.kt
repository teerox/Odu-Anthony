package com.example.anthonyodu.repository

import androidx.lifecycle.MutableLiveData
import com.example.anthonyodu.datasource.CarOwnerLocalSource
import com.example.anthonyodu.datasource.FilterRemoteDataSource
import com.example.anthonyodu.model.CarOwnerList
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.model.FilterArray
import java.io.File


class DefaultFilterRepository(private var taskRemoteDataSource: FilterRemoteDataSource,private var taskLocalDataSource: CarOwnerLocalSource):FilterRepository {
    override fun getFilter(): MutableLiveData<FilterArray>? {
        return taskRemoteDataSource.getAll()
    }

    override suspend fun readFile(absoluteFile: File): CarOwnerList {
        return taskLocalDataSource.readFile(absoluteFile)
    }


}
