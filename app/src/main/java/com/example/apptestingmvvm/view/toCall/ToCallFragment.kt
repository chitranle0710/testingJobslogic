package com.example.apptestingmvvm.view.toCall

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apptestingmvvm.MainActivity
import com.example.apptestingmvvm.base.BaseFragment
import com.example.apptestingmvvm.databinding.FragmentToCallBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToCallFragment : BaseFragment<FragmentToCallBinding>(FragmentToCallBinding::inflate) {
    private val callViewModel: ToCallViewModel by viewModels()
    private val adapter by lazy {
        ToCallListAdapter()
    }

    override fun initialView(savedInstanceState: Bundle?) {
        initRecyclerView()
        getListCallItems()
        registerObserver()
    }

    private fun initRecyclerView() {
        binding.rvCall.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.rvCall.setHasFixedSize(true)
        binding.rvCall.adapter = adapter
    }

    private fun getListCallItems() {
        callViewModel.getListItemsCall()
    }

    private fun registerObserver() {
        callViewModel.mutableListCallLiveData.observe(viewLifecycleOwner) {
            adapter.differ.submitList(it)
        }
        callViewModel.loadingData.observe(viewLifecycleOwner) {
            (activity as MainActivity).isShowLoading(it)

        }
    }
}