package com.app.platformscience.presentation.shipment

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.platformscience.data.entity.Driver
import com.app.platformscience.data.entity.Shipment
import com.app.platformscience.domain.ShipmentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject

@HiltViewModel
class ShipmentViewModel @Inject constructor(
    private val shipmentRepository: ShipmentRepository,
    private val stateHandle: SavedStateHandle
) : ViewModel() {
    val shipment: Flow<ShipmentUiState> = flow {
        val shipments = shipmentRepository.getShipments()
        val args = ShipmentFragmentArgs.fromSavedStateHandle(stateHandle)
        val shipment = getMaxScoreShipment(shipments, args.driver)
        emit(shipment)
    }.shareIn(scope = viewModelScope, started = SharingStarted.WhileSubscribed(), replay = 1)

    private fun getMaxScoreShipment(shipments: List<Shipment>, driver: Driver): ShipmentUiState =
        shipments.map {
            val score = getSuitabilityScore(driver, it)
            ShipmentUiState(driver, it, score)
        }.maxByOrNull {
            it.suitabilityScore
        }!!

    private fun getSuitabilityScore(driver: Driver, shipment: Shipment): Double {
        val bassSS: Double = if (shipment.address.length % 2 == 0) {
            driver.name.countVowels() * 1.5
        } else {
            driver.name.countConsonants() * 1.0
        }
        val driverNameLength = driver.name.length
        val shipmentAddressLength = shipment.address.length
        val hasCommonFactor = haveCommonFactor(driverNameLength, shipmentAddressLength)
        return if (hasCommonFactor) {
            val fiftyPercent = bassSS * 0.5
            bassSS + fiftyPercent
        } else {
            bassSS
        }
    }

    private fun haveCommonFactor(no1: Int, no2: Int): Boolean {
        var n1: Int = no1
        var n2: Int = no2
        if (n1 == n2) return true
        while (n1 != n2) {
            if (n1 > n2)
                n1 -= n2
            else
                n2 -= n1
        }
        return n1 > 1
    }

    private fun String.countVowels(): Int =
        this.lowercase()
            .count { it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u' }

    private fun String.countConsonants(): Int {
        val vowels = this.lowercase().filter { it.isLetter() }.countVowels()
        return this.filter { it.isLetter() }.length - vowels
    }
}

data class ShipmentUiState(
    val driver: Driver,
    val shipment: Shipment,
    val suitabilityScore: Double
)