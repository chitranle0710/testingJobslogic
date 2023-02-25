package com.example.apptestingmvvm.view.home

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.example.apptestingmvvm.R
import com.example.apptestingmvvm.base.BaseFragment
import com.example.apptestingmvvm.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun initialView(savedInstanceState: Bundle?) {
        onClick()
    }

    private fun onClick() {
        binding.btnCall.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_toCallFragment)
        }
        binding.btnBuy.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_toBuyFragment)
        }
        binding.btnSell.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_toSellFragment)
        }
    }
}