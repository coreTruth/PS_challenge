package com.app.platformscience.presentation.driver

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.platformscience.data.entity.Driver
import com.app.platformscience.domain.DriverRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject

@HiltViewModel
class DriverViewModel @Inject constructor(
    private val driverRepository: DriverRepository
) : ViewModel() {
    val drivers: Flow<List<Driver>> = flow {
        emit(driverRepository.getDrivers())
    }.shareIn(scope = viewModelScope, started = SharingStarted.WhileSubscribed(), replay = 1)

}