package com.example.anthonyodu.screens.filter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.anthonyodu.App

import com.example.anthonyodu.R
import com.example.anthonyodu.Utility
import com.example.anthonyodu.databinding.FragmentFilterBinding
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.viewmodel.FilterViewModel
import com.example.anthonyodu.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass.
 */
class FilterFragment : Fragment() {

    lateinit var binding:FragmentFilterBinding
    lateinit var recyclerView: RecyclerView
    lateinit var colourRecyclerView: RecyclerView
    private val filterViewModel by viewModels<FilterViewModel>{
        ViewModelFactory((requireContext().applicationContext as App).filterRepoInterface)
    }
    lateinit var adapter: FilterListAdapter
    var arrayUser = arrayListOf<Filter>()
    var arrayColor = arrayListOf<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_filter,container,false)

        recyclerView = binding.allFilter

        filterViewModel.filterList.observeForever {
            if(it == null){
                Toast.makeText(requireContext(),"No Network",Toast.LENGTH_LONG).show()
            }
            it.map {Filter ->
               var country =  Filter.countries
                var color = Filter.colors
                //Log.e("Images", Filter.colors.toString())
            }
            arrayUser.addAll(it)
            arrayColor.addAll(it[0].colors)
           // Log.e("My Text", arrayUser.toString())
            adapter = FilterListAdapter(requireContext(),arrayUser) {}
            recyclerView.adapter = adapter
            binding.progressbar.visibility = View.GONE
            //adapter.notifyDataSetChanged()
        }

        //Check if network is available
        if (!Utility().isNetworkAvailable(context!!)!!) {
            val snack =
                Snackbar.make(binding.root, "No internet connection", Snackbar.LENGTH_INDEFINITE)
            snack.setAction("Ok!") {
                snack.dismiss()
            }
            snack.show()
            Toast.makeText(context, "No internet connection", Toast.LENGTH_LONG).show()
        }



        return binding.root
    }

}
