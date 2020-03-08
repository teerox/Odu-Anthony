package com.example.anthonyodu

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.example.anthonyodu.datasource.FilterRemoteDataSource
import com.example.anthonyodu.repository.DefaultFilterRepository
import com.example.anthonyodu.repository.FilterRepository

object ServiceLocator
{
    @Volatile
    var filterRepoInterface:FilterRepository? = null
        @VisibleForTesting

    private var lock = Any()

    fun provideFilterRepository():FilterRepository{
        synchronized(this){
            return filterRepoInterface?:createFilterRepository()
        }
    }

    private fun createFilterRepository(): FilterRepository {
        val newRepository = DefaultFilterRepository(FilterRemoteDataSource())

        filterRepoInterface = newRepository
        return newRepository
    }


}