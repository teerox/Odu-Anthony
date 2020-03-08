package com.example.anthonyodu.screens.carowner

import android.os.Environment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.anthonyodu.download.Download
import com.example.anthonyodu.model.CarOwnerList
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.screens.carowner.FilterManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.File

class CarOwnerViewModel(private val mydata: Filter):ViewModel(){

    private val absoluteFile by lazy {
        File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
            Download.FOLDER.plus("/${Download.CAR_OWNER_DATA}")
        )
    }

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var _filterResult = MutableLiveData<CarOwnerList>()
    val filterResult: LiveData<CarOwnerList>
        get() = _filterResult


    private var _isDbAvailable = MutableLiveData<Boolean>()
    val isDbAvailable: LiveData<Boolean>
        get() = _isDbAvailable


    init {
        if (!absoluteFile.exists()) {
            _isDbAvailable.value = false

        } else {
            val filterManager = FilterManager()
            uiScope.launch {
                val fileList = filterManager.readFile(absoluteFile)
                _filterResult.value = filterManager.filter(fileList, mydata)
            }
            _isDbAvailable.value = true
        }


    }
}