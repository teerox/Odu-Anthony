package com.example.anthonyodu.datasource

import androidx.lifecycle.MutableLiveData
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.model.FilterArray
import com.example.anthonyodu.network.MyRetrofitBuilder
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import retrofit2.await
import java.lang.Error
import javax.security.auth.callback.Callback

class FilterRemoteDataSource(private var ioDispatcher:CoroutineDispatcher = Dispatchers.IO):FilterDataSource<FilterArray> {
    private val apiService = MyRetrofitBuilder.provideMovieApi()

    override fun getAll(): MutableLiveData<FilterArray>? {
        var data = arrayListOf<Filter>()
        val filter: MutableLiveData<FilterArray>? = MutableLiveData()

        //val allFilter = apiService.getAllFilterAsync().await().result
        val call = apiService.getAllFilterAsync()
        call.enqueue(object : Callback, retrofit2.Callback<FilterArray> {
            override fun onFailure(call: Call<FilterArray>, t: Throwable) {
                filter?.value = data
                    }

            override fun onResponse(call: Call<FilterArray>, response: Response<FilterArray>) {
                if (response.isSuccessful) {

                    filter?.value = response.body()
                }
                }
        })
        return filter
    }

}