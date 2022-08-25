package com.app.platformscience.presentation.driver

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.app.platformscience.R
import com.app.platformscience.data.entity.Driver
import com.app.platformscience.databinding.FragmentDriverBinding
import com.app.platformscience.presentation.common.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DriverFragment : Fragment(R.layout.fragment_driver), (Driver) -> Unit {
    private val binding by viewBinding<FragmentDriverBinding>()
    private val viewModel by viewModels<DriverViewModel>()
    private lateinit var adapter: DriverAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = DriverAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        observeUIState()
    }

    private fun observeUIState() = lifecycleScope.launch {
        viewModel.drivers.flowWithLifecycle(lifecycle).collect(adapter::submitList)
    }

    override fun invoke(driver: Driver) {
        val direction = DriverFragmentDirections.actionDriverToShipment(driver)
        findNavController().navigate(direction)
    }
}