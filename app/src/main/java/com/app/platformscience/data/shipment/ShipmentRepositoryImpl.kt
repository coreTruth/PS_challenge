package com.app.platformscience.data.shipment

import com.app.platformscience.data.entity.Shipment
import com.app.platformscience.domain.ShipmentRepository
import javax.inject.Inject

class ShipmentRepositoryImpl @Inject constructor(
    private val shipmentDataSource: ShipmentDataSource
) : ShipmentRepository {

    override suspend fun getShipments(): List<Shipment> =
        shipmentDataSource.getShipments()
}