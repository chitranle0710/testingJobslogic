package com.example.apptestingmvvm.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.apptestingmvvm.R
import com.example.apptestingmvvm.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        onClick()
        return binding?.root
    }

    private fun onClick() {
        binding?.btnCall?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_toCallFragment)
        }
        binding?.btnBuy?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_toBuyFragment)
        }
        binding?.btnSell?.setOnClickListener {

        }
    }
}