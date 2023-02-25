package com.example.apptestingmvvm.view.toBuy

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apptestingmvvm.MainActivity
import com.example.apptestingmvvm.base.BaseFragment
import com.example.apptestingmvvm.data.entity.ItemSell
import com.example.apptestingmvvm.data.entity.ToBuyResponse
import com.example.apptestingmvvm.databinding.FragmentToBuyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToBuyFragment : BaseFragment<FragmentToBuyBinding>(FragmentToBuyBinding::inflate) {
    private val toBuyViewModel: ToBuyViewModel by viewModels()
    private val adapter by lazy {
        ToBuyAdapter()
    }

    override fun initialView(savedInstanceState: Bundle?) {
        initRecyclerView()
        callBuyItemList()
        registerObserver()
    }

    private fun initRecyclerView() {
        binding.rvBuy.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.rvBuy.setHasFixedSize(true)
        binding.rvBuy.adapter = adapter
    }

    private fun callBuyItemList() {
        toBuyViewModel.getListBuyItems()
    }

    private fun registerObserver() {
        toBuyViewModel.mutableListBuyLiveData.observe(viewLifecycleOwner) {
            adapter.differ.submitList(it)
            insertItemBuyToSellList(it)
        }
        toBuyViewModel.loadingData.observe(viewLifecycleOwner) {
            (activity as MainActivity).isShowLoading(it)
        }
    }

    private fun insertItemBuyToSellList(list: List<ToBuyResponse>?) {
        if (!list.isNullOrEmpty()) {
            for (i in list) {
                val itemSell = ItemSell()
                itemSell.name = i.name
                itemSell.price = i.price
                itemSell.quantity = i.quantity
                toBuyViewModel.insertItemToSell(itemSell)
            }
        }
    }

}