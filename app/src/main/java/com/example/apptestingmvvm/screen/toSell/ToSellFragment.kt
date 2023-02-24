package com.example.apptestingmvvm.screen.toSell

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apptestingmvvm.databinding.FragmentToSellBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToSellFragment : Fragment() {
    private var binding: FragmentToSellBinding? = null
    private val sellViewModel: ToSellViewModel by viewModels()
    private val adapter by lazy { ToSellAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentToSellBinding.inflate(layoutInflater)
        initRecyclerView()
        registerObserver()
        return binding?.root
    }

    private fun initRecyclerView() {
        binding?.rvSell?.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding?.rvSell?.setHasFixedSize(true)
        binding?.rvSell?.adapter = adapter
    }

    private fun registerObserver() {
        sellViewModel.getItemSell()
        sellViewModel.showListSellMutableLiveData.observe(viewLifecycleOwner) {
            adapter.differ.submitList(it)
        }
        sellViewModel.errorMessage.observe(viewLifecycleOwner) {
            Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
        }
    }
}