package com.app.platformscience.domain

import com.app.platformscience.data.entity.Shipment

interface ShipmentRepository {
    suspend fun getShipments(): List<Shipment>
}