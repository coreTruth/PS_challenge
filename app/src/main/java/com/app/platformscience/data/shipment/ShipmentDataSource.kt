package com.app.platformscience.data.shipment

import com.app.platformscience.data.entity.Shipment

interface ShipmentDataSource {
    suspend fun getShipments():List<Shipment>
}