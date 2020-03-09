package com.example.anthonyodu.screens.filter

import android.os.Environment
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader
import com.example.anthonyodu.download.Download
import com.example.anthonyodu.download.Download.CAR_OWNER_DATA
import com.example.anthonyodu.model.FilterArray
import com.example.anthonyodu.repository.FilterRepository
import java.io.File

class FilterViewModel(private val filterRepository: FilterRepository):ViewModel(){

    private var _filterList = MutableLiveData<FilterArray>()
    val filterList: LiveData<FilterArray>
        get() = _filterList

    init {
        initializeFetch()
    }

    private fun initializeFetch() {

        filterRepository.getFilter()?.let {
            _filterList = it

        }

    }

    private val file by lazy {
        File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
            Download.FOLDER
        )
    }
    private val absoluteFile by lazy {
        File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
            Download.FOLDER.plus("/$CAR_OWNER_DATA")
        )
    }


    private val _startDialogDownload = MutableLiveData<Boolean>()
    val startDialogDownload: LiveData<Boolean>
        get() = _startDialogDownload

    private val _completeDownload = MutableLiveData<Boolean>()
    val completeDownload: LiveData<Boolean>
        get() = _completeDownload


    val grantAccess = MutableLiveData<Boolean>()


    fun checkDataExist() {
        if (!absoluteFile.exists()) {
            _startDialogDownload.value = false
            startDownload()
        }


    }


    private fun startDownload(): Int {
        if (!file.exists()) file.mkdir()
        return PRDownloader.download(
            Download.DOWNLOAD_URL,
            file.absolutePath,
            CAR_OWNER_DATA
        )
            .build()
            .setOnStartOrResumeListener {
               Log.e("Started","Started")
            }
            .setOnPauseListener {
                Log.e("Pause","Pause")
            }
            .setOnCancelListener {
                Log.e("Cancel","Cancel")
            }
            .setOnProgressListener { }
            .start(object : OnDownloadListener {
                override fun onDownloadComplete() {
                    _completeDownload.value = true
                    grantAccess.value = true
                    Log.e("Completed","Completed")
                }

                override fun onError(error: com.downloader.Error?) {
                   Log.e("error",error?.serverErrorMessage.toString())
                    _completeDownload.value = true

                }
            })
    }


}