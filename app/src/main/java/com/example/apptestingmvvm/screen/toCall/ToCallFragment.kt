package com.example.apptestingmvvm.screen.toCall

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apptestingmvvm.MainActivity
import com.example.apptestingmvvm.R
import com.example.apptestingmvvm.databinding.FragmentToCallBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToCallFragment : Fragment() {
    private val callViewModel: ToCallViewModel by viewModels()
    private var binding: FragmentToCallBinding? = null
    private val adapter by lazy {
        ToCallListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentToCallBinding.inflate(layoutInflater)
        initRecyclerView()
        getListCallItems()
        registerObserver()
        return binding?.root
    }

    private fun initRecyclerView() {
        binding?.rvCall?.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding?.rvCall?.setHasFixedSize(true)
        binding?.rvCall?.adapter = adapter
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