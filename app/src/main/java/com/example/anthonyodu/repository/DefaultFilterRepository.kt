package com.example.anthonyodu.repository

import androidx.lifecycle.MutableLiveData
import com.example.anthonyodu.datasource.FilterRemoteDataSource
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.model.FilterArray


class DefaultFilterRepository(private var taskRemoteDataSource: FilterRemoteDataSource):FilterRepository {
    override fun getFilter(): MutableLiveData<FilterArray>? {
        return taskRemoteDataSource.getAll()
    }


}
