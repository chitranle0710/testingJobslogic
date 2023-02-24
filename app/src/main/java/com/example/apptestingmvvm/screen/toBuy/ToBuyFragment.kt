package com.example.apptestingmvvm.screen.toBuy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apptestingmvvm.MainActivity
import com.example.apptestingmvvm.R
import com.example.apptestingmvvm.databinding.FragmentToBuyBinding
import com.example.apptestingmvvm.screen.toCall.ToCallListAdapter
import com.example.apptestingmvvm.screen.toCall.ToCallViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToBuyFragment : Fragment() {
    private var binding: FragmentToBuyBinding? = null
    private val toBuyViewModel: ToBuyViewModel by viewModels()
    private val adapter by lazy {
        ToBuyAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentToBuyBinding.inflate(layoutInflater)
        initRecyclerView()
        callBuyItemList()
        registerObserver()
        return binding?.root
    }

    private fun initRecyclerView() {
        binding?.rvBuy?.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding?.rvBuy?.setHasFixedSize(true)
        binding?.rvBuy?.adapter = adapter
    }

    private fun callBuyItemList() {
        toBuyViewModel.getListBuyItems()
    }

    private fun registerObserver() {
        toBuyViewModel.mutableListBuyLiveData.observe(viewLifecycleOwner) {
            adapter.differ.submitList(it)
        }
        toBuyViewModel.loadingData.observe(viewLifecycleOwner) {
            (activity as MainActivity).isShowLoading(it)
        }
    }

}