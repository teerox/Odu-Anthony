package com.example.anthonyodu.screens.filter

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.downloader.PRDownloader
import com.downloader.PRDownloaderConfig
import com.example.anthonyodu.App
import com.example.anthonyodu.DownloadProgress

import com.example.anthonyodu.R
import com.example.anthonyodu.Utility
import com.example.anthonyodu.Utility.MY_PERMISSIONS_REQUEST_WRITE_STORAGE
import com.example.anthonyodu.broadcastReceivers.NetworkChangeReceiver
import com.example.anthonyodu.databinding.FragmentFilterBinding
import com.example.anthonyodu.model.Filter
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass.
 */
class FilterFragment : Fragment(){
    lateinit var binding:FragmentFilterBinding
    lateinit var recyclerView: RecyclerView
    lateinit var reciever: NetworkChangeReceiver
    private val filterViewModel by viewModels<FilterViewModel>{
        ViewModelFactory((requireContext().applicationContext as App).filterRepoInterface)
    }
    lateinit var adapter: FilterListAdapter
    private lateinit var loadingFrag: DownloadProgress
    var arrayUser = arrayListOf<Filter>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_filter,container,false)



        //Check for Permission
        checkPermissionAndStart()


        //Initialize Download
        val config = PRDownloaderConfig.newBuilder().setDatabaseEnabled(true).build()
        PRDownloader.initialize(context, config)

        recyclerView = binding.allFilter
        reciever = NetworkChangeReceiver()


        filterViewModel.filterList.observeForever {
            if (it.isEmpty()) {
                adapter = FilterListAdapter(requireContext(), arrayUser) {}
                recyclerView.adapter = adapter
                binding.progressbar.visibility = View.VISIBLE
            } else {
                arrayUser.addAll(it)
                adapter = FilterListAdapter(requireContext(), arrayUser) {}
                recyclerView.adapter = adapter
                binding.progressbar.visibility = View.GONE
            }
        }


        filterViewModel.startDialogDownload.observe(viewLifecycleOwner, Observer {
            if (!it) {
                loadingFrag = DownloadProgress(context)
                loadingFrag.showDialog()
                Snackbar.make(binding.root,"Downloaded Started",Snackbar.LENGTH_LONG).show()

            }
        })
        filterViewModel.completeDownload.observe(viewLifecycleOwner, Observer { isCompleted ->
            isCompleted?.let { result ->
                if (result) {
                    loadingFrag.dismiss()
                    Snackbar.make(binding.root,"Downloaded Completed",Snackbar.LENGTH_LONG).show()
                }
            }
        })

        return binding.root

    }

    //METHOD TO CHECK PERMISSION
    private fun checkPermissionAndStart() {
        if (ContextCompat.checkSelfPermission(
                context!!,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            promptDialogPermission()

        } else {
            filterViewModel
            filterViewModel.grantAccess.value = true
        }
    }



    private fun promptDialogPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                Utility.MY_PERMISSIONS_REQUEST_WRITE_STORAGE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_WRITE_STORAGE -> {
                if ((grantResults.isNotEmpty() && permissions[0] == Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        filterViewModel.checkDataExist()
                        filterViewModel.grantAccess.value = true
                    }
                } else {
                    promptDialogPermission()
                }

            }


        }
    }



}
