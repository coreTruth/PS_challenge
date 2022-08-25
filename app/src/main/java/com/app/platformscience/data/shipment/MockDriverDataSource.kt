package com.app.platformscience.data.shipment

import com.app.platformscience.data.entity.Shipment
import javax.inject.Inject

class MockShipmentDataSource @Inject constructor() : ShipmentDataSource {
    override suspend fun getShipments(): List<Shipment> =
        listOf(
            Shipment(address = "215 Osinski Manors"),
            Shipment(address = "9856 Marvin Stravenue"),
            Shipment(address = "7127 Kathlyn Ferry"),
            Shipment(address = "987 Champlin Lake"),
            Shipment(address = "63187 Volkman Garden Suite 447"),
            Shipment(address = "75855 Dessie Lights"),
            Shipment(address = "1797 Adolf Island Apt. 744"),
            Shipment(address = "2431 Lindgren Corners"),
            Shipment(address = "8725 Aufderhar River Suite 859"),
            Shipment(address = "79035 Shanna Light Apt. 322"),

            )
}