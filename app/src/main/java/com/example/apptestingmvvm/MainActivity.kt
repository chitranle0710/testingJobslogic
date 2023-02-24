package com.example.apptestingmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.apptestingmvvm.databinding.ActivityMainBinding
import com.example.apptestingmvvm.screen.viewmodel.MainViewModel
import com.example.apptestingmvvm.util.beGone
import com.example.apptestingmvvm.util.beVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModels: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setUpNavHost()
        setContentView(binding.root)
    }

    private fun setUpNavHost() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }

    fun isShowLoading(isShow: Boolean) {
        if (isShow) {
            binding.progressBar.beVisible()
        } else {
            binding.progressBar.beGone()
        }
    }

}