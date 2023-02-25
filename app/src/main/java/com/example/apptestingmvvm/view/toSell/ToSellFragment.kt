package com.example.apptestingmvvm.view.toSell

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apptestingmvvm.base.BaseFragment
import com.example.apptestingmvvm.databinding.FragmentToSellBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToSellFragment : BaseFragment<FragmentToSellBinding>(FragmentToSellBinding::inflate) {
    private val sellViewModel: ToSellViewModel by viewModels()
    private val adapter by lazy { ToSellAdapter() }
    override fun initialView(savedInstanceState: Bundle?) {
        initRecyclerView()
        registerObserver()
    }

    private fun initRecyclerView() {
        binding.rvSell.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.rvSell.setHasFixedSize(true)
        binding.rvSell.adapter = adapter
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