package com.example.anthonyodu.screens.carowner

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.anthonyodu.App

import com.example.anthonyodu.R
import com.example.anthonyodu.databinding.FragmentCarOwnerBinding
import com.example.anthonyodu.databinding.FragmentFilterBinding
import com.example.anthonyodu.model.CarOwner
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.screens.filter.FilterFragmentDirections
import com.example.anthonyodu.screens.filter.FilterListAdapter
import com.example.anthonyodu.screens.filter.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass.
 */
class CarOwnerFragment : Fragment() {

    lateinit var binding:FragmentCarOwnerBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CarOwnerAdapter
    var arrayUser = arrayListOf<CarOwner>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_car_owner,container,false)

        recyclerView = binding.carOwnerRecy
        var args = CarOwnerFragmentArgs.fromBundle(arguments!!).Filterlist
        val carOwnerViewModel by viewModels<CarOwnerViewModel>{
            CarOwnerViewModelFactory((requireContext().applicationContext as App).filterRepoInterface,args )
        }

        carOwnerViewModel.filterResult.observe(viewLifecycleOwner, Observer {
            filterResult->
            arrayUser.addAll(filterResult)
            adapter = CarOwnerAdapter(requireContext(), arrayUser)
            recyclerView.adapter = adapter
            binding.progressbar2.visibility = View.GONE
          //  Log.e("Filtered Result", filterResult.toString())
            val total = filterResult.size
            Snackbar.make(binding.root,total.toString(), Snackbar.LENGTH_LONG).show()
        })

        carOwnerViewModel.isDbAvailable.observe(viewLifecycleOwner, Observer {
            if(!it){
                Snackbar.make(binding.root,"No List Available", Snackbar.LENGTH_LONG).show()

            }
        })

        return binding.root
    }

}
