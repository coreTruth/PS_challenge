package com.app.platformscience.presentation.shipment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.app.platformscience.R
import com.app.platformscience.databinding.FragmentShipmentBinding
import com.app.platformscience.presentation.common.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ShipmentFragment : Fragment(R.layout.fragment_shipment) {
    private val binding by viewBinding<FragmentShipmentBinding>()
    private val viewModel by viewModels<ShipmentViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeUIState()
    }

    private fun initViews() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun observeUIState() = lifecycleScope.launch {
        viewModel.shipment.flowWithLifecycle(lifecycle).collect {
            binding.textShipmentAddress.text = it.shipment.address
            binding.textSuitabilityScore.text = "${it.suitabilityScore}"
            binding.textDriverName.text = it.driver.name
        }
    }
}